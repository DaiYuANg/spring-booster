/* (C)2024*/
package org.spring.boost.common.api;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

public interface BeanRegistry {

	<A extends Annotation, T> Map<A, T> getBeanWithAnnotationMap(Class<A> annotation, Class<T> beanType);

	<T> Collection<T> getBeanWithAnnotation(Class<? extends Annotation> annotation, Class<T> beanType);

	<T> Stream<T> findByAnnotation(Class<? extends Annotation> annotation, Class<T> beanType);

	<T> void register(String name, T bean);

	<T> void registerAll(@NotNull Map<String, T> beans);
}
