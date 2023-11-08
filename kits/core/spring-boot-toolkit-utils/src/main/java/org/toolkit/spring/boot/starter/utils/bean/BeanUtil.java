package org.toolkit.spring.boot.starter.utils.bean;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BeanUtil {
	@Resource
	private ApplicationContext context;

	@Resource
	private DefaultListableBeanFactory beanFactory;

	public <T> List<T> findBeans(Class<T> clazz) {
		return context.getBeansOfType(clazz).values().stream().toList();
	}

	public <T> Optional<T> getBeansWithGenericType(Class<T> clazz, Class<T> genericTypes) {
		val type = ResolvableType.forClassWithGenerics(clazz, genericTypes);
		return Optional.ofNullable(context.<T>getBeanProvider(type).getIfAvailable());
	}
}
