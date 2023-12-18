/* (C)2023*/
package org.toolkit.spring.boot.vertx;

import io.vertx.core.Vertx;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.toolkit.spring.boot.utils.autoconfigure.SpringBootUtilAutoConfiguration;
import org.toolkit.spring.boot.vertx.configuration.VertxAutoConfiguration;
import org.toolkit.spring.boot.vertx.configuration.builder.VertxConfigBuilder;
import org.toolkit.spring.boot.vertx.lifecycle.VerticleRegister;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest(
		classes = {
			VertxAutoConfiguration.class,
			VertxConfigBuilder.class,
			VerticleRegister.class,
			SpringBootUtilAutoConfiguration.class
		})
public class TestVertxAutoConfiguration {

	@Resource
	private Vertx vertx;

	@Resource
	private ApplicationContext context;

	@TestConfiguration
	static class TestConfigurationForVertielce {
		@Bean
		public TestVertivle testVertivle() {
			return new TestVertivle();
		}
	}

	@Test
	public void test() {
		Assertions.assertNotNull(vertx);
	}

	@Test
	public void testVerticle() {
		val t = context.getBean(TestVertivle.class);
		Assertions.assertNotNull(t);
	}
}
