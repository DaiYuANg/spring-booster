package org.spring.boost.admin.lifecycle;

import io.javalin.Javalin;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.dreamlu.mica.auto.annotation.AutoListener;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.admin.api.RouteBinder;
import org.spring.boost.core.api.BeanRegistry;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;


@AutoListener
@Slf4j
@SuppressWarnings("unused")
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {

  @Override
  public void onApplicationEvent(@NotNull ContextRefreshedEvent event) {
    val context = event.getApplicationContext();
    val registry = context.getBean(BeanRegistry.class);
    val javalin = registry.get(Javalin.class);
    bindRoute(javalin, registry);
    javalin.start(10000);
  }

  private void bindRoute(@NotNull Javalin app, @NotNull BeanRegistry beanRegistry) {
    val controllers = beanRegistry.getBeanDistinct(RouteBinder.class);
    controllers.forEach(controller-> controller.binding(app));
  }
}
