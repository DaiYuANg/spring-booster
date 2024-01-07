/* (C)2024*/
package org.spring.boost.core.api;

import com.google.common.collect.ImmutableMap;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;

public interface BeanRegistry {

    /**
     * Finds beans by a specified annotation and bean type, returning a map with keys as annotation instances and values as corresponding beans.
     * @param annotation Annotation The annotation class to search for.
     * @param beanType beanType The type of the beans to search for.
     * @return A map with keys as annotation instances and values as corresponding beans.
     * @param <A> <A> The type of the annotation.
     * @param <T> <T> The type of the beans.
     */
    <A extends Annotation, T> Map<A, T> getBeanWithAnnotationMap(Class<A> annotation, Class<T> beanType);

    <T> Collection<T> getBeanWithAnnotation(Class<? extends Annotation> annotation, Class<T> beanType);

    <T> Collection<T> getBeanWithAnnotationImmutable(Class<? extends Annotation> annotation, Class<T> beanType);

    <T> Set<T> getBeanDistinct(Class<T> beanTypeClass);

    <T> ImmutableMap<String, T> getBeanOfTypeImmutable(Class<T> beanType);

    <T> Stream<T> findByAnnotation(Class<? extends Annotation> annotation, Class<T> beanType);

    <T> void register(String name, T bean);

    <T> void registerAll(@NotNull Map<String, T> beans);
}
