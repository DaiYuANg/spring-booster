package org.toolkit.spring.boot.scanner.lifecycle;

import io.github.classgraph.ClassGraph;
import java.util.ServiceLoader;
import java.util.function.Function;
import java.util.stream.Stream;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationListener;
import org.toolkit.spring.boot.scanner.autoconfigure.ScannerConfigurationProperties;
import org.toolkit.spring.boot.scanner.base.ScannerResultProcessor;

@Slf4j
public class ApplicationPreparedListener implements ApplicationListener<ApplicationPreparedEvent> {

	@Override
	public void onApplicationEvent(@NotNull ApplicationPreparedEvent event) {
		val ann = event.getSpringApplication().getMainApplicationClass().getAnnotation(SpringBootApplication.class);
		val applicationContext = event.getApplicationContext();
		val binder = Binder.get(applicationContext.getEnvironment());
		val config = ScannerConfigurationProperties.get(binder);
		val scanPackage = Stream.of(ann.scanBasePackages());
		val mainPackage =
				Stream.of(event.getSpringApplication().getMainApplicationClass().getPackageName());
		val scan = Stream.of(scanPackage, mainPackage, config.getClassPath().stream())
				.distinct()
				.flatMap(Function.identity())
				.toArray(String[]::new);
		val classgraph = new ClassGraph().enableAllInfo().acceptClasses(scan);
		if (config.getDebug()) {
			classgraph.enableRealtimeLogging();
		}
		@Cleanup val result = classgraph.scan(Runtime.getRuntime().availableProcessors());
		val scannerResultProcessors = ServiceLoader.load(ScannerResultProcessor.class);
		log.atDebug().log("processor:{}", scannerResultProcessors);
		scannerResultProcessors.forEach(service -> service.process(result, event.getApplicationContext()));
		Runtime.getRuntime().gc();
	}
}
