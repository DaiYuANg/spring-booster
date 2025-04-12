package org.spring.boost.admin.autoconfigure;

import io.javalin.Javalin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import oshi.SystemInfo;

@AutoConfiguration
@Slf4j
@RequiredArgsConstructor
public class SpringBoostAdminAutoConfigure {

//  @Bean
//  Vertx vertx() {
//    return Vertx.vertx();
//  }
//
//  @Bean
//  HttpServer httpServer(Vertx vertx) {
//    return vertx.createHttpServer();
//  }

//  @Bean
//  Router router(Vertx vertx,
//                List<Route> routeList
//  ) {
//    val router = Router.router(vertx);
//    router.route().handler(BodyHandler.create());
//    router.get().handler(StaticHandler.create());
//    routeList.forEach(route -> router.route(route.method(), "/api/" + route.path()).handler(route));
//
//    return router;
//  }
//
//  @Bean
//  WebClient webClient(Vertx vertx) {
//    return WebClient.create(vertx);
//  }

  @Bean
  Javalin javalin() {
    return Javalin.create(config -> {
      config.bundledPlugins.enableDevLogging();
      config.showJavalinBanner = false;
      config.startupWatcherEnabled = true;
    });
  }

  @Bean
  SystemInfo systemInfo() {
    return new SystemInfo();
  }
}
