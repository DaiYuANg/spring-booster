package org.toolkit.spring.boot.vertx.configuration;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.CorsHandler;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.vertx.configuration.properties.HttpConfigurationProperties;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(HttpConfigurationProperties.class)
public class HttpAutoConfiguration {

	@Resource
	private Vertx vertx;

	@Bean
	public Router rootRouter() {
		val router = Router.router(vertx);
		router.route().handler(BodyHandler.create());
		router.route().handler(corsHandler());
		return router;
	}

	public CorsHandler corsHandler() {
		return CorsHandler.create().addRelativeOrigin("vertx\\.io").allowedMethod(HttpMethod.GET);
	}
}
