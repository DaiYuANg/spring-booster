/* (C)2024*/
package org.spring.boost.core.listener;

import io.github.classgraph.ClassGraph;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.dreamlu.mica.auto.annotation.AutoListener;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.api.ClassPathScannerFeatureInstaller;
import org.spring.boost.core.autoconfigure.CoreConfigurationProperties;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationListener;

import java.util.ServiceLoader;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@Slf4j
@AutoListener
@SuppressWarnings("unused")
public class ContextRefreshListener implements ApplicationListener<ApplicationPreparedEvent> {
  private final ClassGraph classGraph = new ClassGraph();

  {
    classGraph.enableAllInfo();
  }

  private final ThreadFactory threadFactory = Thread.ofPlatform()
    .name(this.getClass().getName() + "-", 0)
    .factory();

  private final int parallel = Runtime.getRuntime().availableProcessors() * 2;

  private final ServiceLoader<ClassPathScannerFeatureInstaller> scannerResultHandles;

  public ContextRefreshListener() {
    this.scannerResultHandles = ServiceLoader.load(ClassPathScannerFeatureInstaller.class);
  }

  @Override
  @SuppressWarnings({"StaticImport", "ImmutableListBuilder"})
  public void onApplicationEvent(@NotNull ApplicationPreparedEvent event) {
    val mainClass = event.getSpringApplication().getMainApplicationClass();
    val context = event.getApplicationContext();
    val binder = Binder.get(context.getEnvironment());
    val config = CoreConfigurationProperties.get(binder);
    @Cleanup val executor = Executors.newThreadPerTaskExecutor(threadFactory);
    log.atTrace().log("Boost Core Listener Active");
    log.atTrace().log("Core config:{}", config);

    classGraph.verbose(config.getClassScanner().getVerbose());

    if (config.getClassScanner().getEnableClassGraphLog()) {
      classGraph.enableRealtimeLogging();
    }
    classGraph.acceptPackages(mainClass.getPackageName());
    classGraph.rejectPackages("org.spring.springframework");

    @Cleanup val result = classGraph.scan(executor, parallel);

    Observable.fromIterable(scannerResultHandles)
      .flatMap(handle -> Observable.fromRunnable(() -> {
        handle.install(context, result);
      }).subscribeOn(Schedulers.from(executor))).blockingSubscribe();
  }

  @Override
  public boolean supportsAsyncExecution() {
    return true;
  }
}
