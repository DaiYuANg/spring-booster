package org.toolkit4j.examples.frameworks.spring.curd.example;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.toolkit4j.framework.spring.boot.starter.dict.annotation.EnableDict;

import java.util.HashMap;

// import org.toolkit4j.framework.spring.starter.monitor.annotations.EnableDevAdmin;

@SpringBootApplication(scanBasePackages = {"org.toolkit4j.examples.frameworks.spring.curd.example"})
@EnableDict
// @EnableDevAdmin
@Slf4j
public class SpringBootCurdExample extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(@NotNull SpringApplicationBuilder builder) {
//		new HashMap<>().
		return builder.sources(SpringBootCurdExample.class);
	}

	@SneakyThrows
	public static void main(String[] args) {
		val app = new SpringApplication(SpringBootCurdExample.class);
		app.setApplicationStartup(new BufferingApplicationStartup(2048));
		app.run(args);
	}
}
