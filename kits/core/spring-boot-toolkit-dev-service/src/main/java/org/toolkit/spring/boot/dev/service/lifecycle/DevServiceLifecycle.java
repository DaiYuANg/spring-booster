package org.toolkit.spring.boot.dev.service.lifecycle;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.aot.AotDetector;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.util.ClassUtils;
import org.toolkit.spring.boot.dev.service.config.DevServiceConfigurationProperties;
import org.toolkit.spring.boot.dev.service.connection.SupportServiceStore;
import org.toolkit.spring.boot.dev.service.core.ContainerService;
import org.toolkit.spring.boot.dev.service.core.DevServiceReadyEvent;

@Slf4j
public class DevServiceLifecycle {

	private final ApplicationContext context;

	private final Binder binder;

	private final DevServiceConfigurationProperties devServiceConfigurationProperties;

	private final ClassLoader classLoader;

	private final Set<ApplicationListener<?>> eventListeners;

	private final Executor executor;

	private final Set<ContainerService> availableService;

	private final Observable<ContainerService> observable;

	public DevServiceLifecycle(
			@NotNull ApplicationContext context, @NotNull Binder binder, Set<ApplicationListener<?>> eventListeners) {
		this.context = context;
		this.binder = binder;
		this.devServiceConfigurationProperties = DevServiceConfigurationProperties.get(binder);
		this.classLoader = context.getClassLoader();
		this.eventListeners = eventListeners;
		this.availableService = Arrays.stream(SupportServiceStore.values())
				.filter(supportService -> ClassUtils.isPresent(supportService.getClazz(), this.classLoader))
				.map(SupportServiceStore::getContainerService)
				.collect(Collectors.toUnmodifiableSet());
		val threadFactory =
				new ThreadFactoryBuilder().setNameFormat("DevService-%s").build();
		this.observable = Observable.fromIterable(availableService);
		this.executor = Executors.newFixedThreadPool(availableService.size(), threadFactory);
	}

	void start() {
		if (Boolean.getBoolean("spring.aot.processing") || AotDetector.useGeneratedArtifacts()) {
			log.trace("Dev service support disabled with AOT and native images");
			return;
		}
		if (devServiceConfigurationProperties.getEnable().equals(Boolean.FALSE)) {
			log.trace("Dev service is not enable");
			return;
		}
		if (DevServiceSkipCheck.shouldSkip(this.classLoader)) {
			log.trace("Dev service skipped");
			return;
		}
		if (availableService.isEmpty()) {
			log.trace("Available service is empty");
			return;
		}
		val serviceContainerIds = observable
				.flatMap(service -> Observable.just(service)
						.subscribeOn(Schedulers.from(executor))
						.map(ContainerService::startContainer))
				.toList(availableService.size())
				.blockingGet();
	}

	void stop() {
		//     todo  check need stop container
	}

	private void publishEvent(DevServiceReadyEvent event) {
		val multicaster = new SimpleApplicationEventMulticaster();
		eventListeners.forEach(multicaster::addApplicationListener);
		multicaster.multicastEvent(event);
	}
}