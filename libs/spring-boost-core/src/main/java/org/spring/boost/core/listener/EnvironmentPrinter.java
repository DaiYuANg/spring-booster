/* (C)2023*/
package org.spring.boost.core.listener;

import static java.util.Objects.requireNonNullElse;

import java.net.InetAddress;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.dreamlu.mica.auto.annotation.AutoListener;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.api.BeanRegistry;
import org.spring.boost.core.api.FeatureInstaller;
import org.spring.boost.core.model.PrintContext;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;

/**
 * start up info printer
 */
@Slf4j
@RequiredArgsConstructor
@AutoListener
public class EnvironmentPrinter implements ApplicationListener<ApplicationReadyEvent> {

  @Override
  public void onApplicationEvent(@NotNull ApplicationReadyEvent event) {
    val context = event.getApplicationContext();
    val printContext = context.getBean(PrintContext.PrintContextBuilder.class).build();
    log.atInfo().log("Printing environment info:{}", printContext);
    val registry = context.getBean(BeanRegistry.class);
    val boosterFeatures = registry.getBeanDistinct(FeatureInstaller.class);
    log.atInfo().log("Installed features ---------------");

    boosterFeatures.forEach(featureInstaller -> {
      log.atInfo().log("Feature:{}",featureInstaller);
    });
    log.atInfo().log("time {} second", event.getTimeTaken().getSeconds());
  }

  private void printServerEnvironment(ApplicationContext context) {
    val env = context.getEnvironment();
    val ip = InetAddress.getLoopbackAddress().getHostAddress();
    val port = env.getProperty("server.port", "8080");
    val contextPath = requireNonNullElse(env.getProperty("server.servlet.context-path"), "/");
    log.atInfo().log("Server startup http://{}:{}{}", ip, port, contextPath);
  }
}
