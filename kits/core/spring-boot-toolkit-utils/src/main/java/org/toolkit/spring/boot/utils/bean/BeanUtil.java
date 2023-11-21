package org.toolkit.spring.boot.utils.bean;

import java.lang.annotation.Annotation;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BeanUtil {

	private final ApplicationContext context;
	private final DefaultListableBeanFactory factory;

	public BeanUtil(ApplicationContext context, DefaultListableBeanFactory factory) {
		this.context = context;
		this.factory = factory;
	}

	public final <T> List<T> getBeansOfType(Class<T> clazz) {
		return context.getBeansOfType(clazz).values().stream().toList();
	}

	public final <T> List<T> findBeans(Class<T> clazz) {
		return context.getBeansOfType(clazz).values().stream().toList();
	}

	@SafeVarargs
	public final <T> @Nullable T getBeansWithAnnotationAndGenericType(
			Class<T> clazz, Annotation ann, Class<T>... genericType) {
		ResolvableType.forClassWithGenerics(clazz, genericType);
		context.getBeansOfType(clazz);
		return null;
	}

	public final <T> void putAllAsSingleton(@NotNull Map<String, T> beans) {
		beans.forEach(factory::registerSingleton);
	}
}
