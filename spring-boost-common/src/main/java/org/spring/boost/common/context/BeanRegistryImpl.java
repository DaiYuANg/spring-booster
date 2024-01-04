/* (C)2024*/
package org.spring.boost.common.context;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.common.api.BeanRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Builder
@Slf4j
public class BeanRegistryImpl implements BeanRegistry {

    private final ApplicationContext context;

    private final DefaultListableBeanFactory beanFactory;

    @Override
    public <A extends Annotation, T> Map<A, T> getBeanWithAnnotationMap(Class<A> annotation, Class<T> beanType) {
        return findByAnnotation(annotation, beanType)
                .collect(Collectors.toUnmodifiableMap(
                        entry -> Objects.requireNonNull(AnnotationUtils.findAnnotation(entry.getClass(), annotation)),
                        Function.identity()));
    }

    @Override
    public <T> Collection<T> getBeanWithAnnotation(Class<? extends Annotation> annotation, Class<T> beanType) {
        return findByAnnotation(annotation, beanType).collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public <T> Collection<T> getBeanWithAnnotationImmutable(Class<? extends Annotation> annotation, Class<T> beanType) {
        return ImmutableList.<T>builder()
                .addAll(getBeanWithAnnotation(annotation, beanType))
                .build();
    }

    @Override
    public <T> ImmutableMap<String, T> getBeanOfTypeImmutable(Class<T> beanType) {
        return ImmutableMap.copyOf(beanFactory.getBeansOfType(beanType));
    }

    @Override
    @SuppressWarnings("IsNotNull")
    public <T> Stream<T> findByAnnotation(Class<? extends Annotation> annotation, Class<T> beanType) {
        return context.getBeansOfType(beanType).values().stream()
                .filter(bean -> Objects.nonNull(AnnotationUtils.findAnnotation(bean.getClass(), annotation)));
    }

    @Override
    public <T> void register(String name, T bean) {
        beanFactory.registerSingleton(name, bean);
    }

    @Override
    public <T> void registerAll(@NotNull Map<String, T> beans) {
        beans.forEach(beanFactory::registerSingleton);
    }
}
