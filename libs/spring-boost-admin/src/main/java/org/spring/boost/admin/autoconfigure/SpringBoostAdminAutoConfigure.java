package org.spring.boost.admin.autoconfigure;

import io.vertx.mutiny.core.Vertx;
import io.vertx.mutiny.core.http.HttpServer;
import io.vertx.mutiny.ext.web.Router;
import io.vertx.mutiny.ext.web.client.WebClient;
import io.vertx.mutiny.ext.web.common.template.TemplateEngine;
import io.vertx.mutiny.ext.web.handler.BodyHandler;
import io.vertx.mutiny.ext.web.handler.TemplateHandler;
import io.vertx.mutiny.ext.web.templ.thymeleaf.ThymeleafTemplateEngine;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@Slf4j
@RequiredArgsConstructor
public class SpringBoostAdminAutoConfigure {

  @Bean
  Vertx vertx() {
    return Vertx.vertx();
  }

  @Bean
  HttpServer httpServer(Vertx vertx) {
    return vertx.createHttpServer();
  }

  @Bean
  TemplateEngine thymeleafTemplateEngine(Vertx vertx) {
    return ThymeleafTemplateEngine.create(vertx);
  }

  @Bean
  TemplateHandler templateHandler(TemplateEngine thymeleafTemplateEngine) {
    return TemplateHandler.create(thymeleafTemplateEngine);
  }

  @Bean
  Router router(Vertx vertx, TemplateHandler templateHandler) {
    val router = Router.router(vertx);
    router.route().handler(BodyHandler.create());
    router.get("/ui/*").handler(templateHandler);
    return router;
  }

  @Bean
  WebClient webClient(Vertx vertx) {
    return WebClient.create(vertx);
  }

}
