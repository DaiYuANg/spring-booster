package org.toolkit4J.framework.spring.boot.starter.async.bean;

import lombok.SneakyThrows;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.Ordered;

import java.lang.reflect.Field;

public class AsyncBeanRegister implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {
	@SneakyThrows
	@Override
	public void initialize(@NotNull ConfigurableApplicationContext context) {
		val beanFactory = new AsyncBeanFactory(context.getBeanFactory());
		Field field = GenericApplicationContext.class.getDeclaredField("beanFactory");
		field.setAccessible(true);
		field.set(context, beanFactory);
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
