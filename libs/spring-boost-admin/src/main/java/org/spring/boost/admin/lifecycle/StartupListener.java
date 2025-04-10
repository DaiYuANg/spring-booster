package org.spring.boost.admin.lifecycle;

import io.vertx.mutiny.core.http.HttpServer;
import io.vertx.mutiny.ext.web.Router;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.dreamlu.mica.auto.annotation.AutoListener;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

@AutoListener
@RequiredArgsConstructor
@Slf4j
public class StartupListener implements ApplicationListener<ApplicationStartedEvent> {

  @Override
  public void onApplicationEvent(@NotNull ApplicationStartedEvent event) {
    val ctx = event.getApplicationContext();
    val server = ctx.getBean(HttpServer.class);
    val router = ctx.getBean(Router.class);
    server.requestHandler(router).listen(10000).subscribe().with(t->{
      log.atInfo().log("Admin server started on port 10000");
    });
  }
}
