package org.toolkit.spring.boot.utils.bean;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BeanUtil {
	private final ApplicationContext context;

	private final DefaultListableBeanFactory beanFactory;

	public BeanUtil(ApplicationContext context, DefaultListableBeanFactory factory) {
		this.context = context;
		this.beanFactory = factory;
	}

	public <T> List<T> findBeans(Class<T> clazz) {
		return context.getBeansOfType(clazz).values().stream().toList();
	}

	@Contract("_, _, _ -> new")
	public final <T> @NotNull Map<String, T> getBeansWithAnnotationAndGenericType(
			Class<?> clazz, Class<? extends Annotation> annotation, Class<?>... genericTypes) {
		val type = ResolvableType.forClassWithGenerics(clazz, genericTypes);
		context.getBeansWithAnnotation(annotation);
		return new HashMap<>();
	}

	@SafeVarargs
	public final <T> Optional<T> getBeansWithGenericType(Class<T> clazz, Class<T>... genericTypes) {
		val type = ResolvableType.forClassWithGenerics(clazz, genericTypes);
		return Optional.ofNullable(context.<T>getBeanProvider(type).getIfAvailable());
	}

	public final <T> List<T> getBeansOfType(Class<T> tClass) {
		return context.getBeansOfType(tClass).values().stream().toList();
	}

	public final <T> void putAllAsSingleton(Map<String, T> beans) {}
}
