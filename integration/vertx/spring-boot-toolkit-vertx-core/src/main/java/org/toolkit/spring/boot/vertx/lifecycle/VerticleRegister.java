package org.toolkit.spring.boot.vertx.lifecycle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.toolkit.spring.boot.utils.bean.BeanUtil;

@AutoConfiguration
@Slf4j
public class VerticleRegister {

	@Resource
	private Vertx vertx;

	@Resource
	private BeanUtil beanUtil;

	@PostConstruct
	public void init() {
		beanUtil.getBeansOfType(AbstractVerticle.class).forEach(vertx::deployVerticle);
	}
}
