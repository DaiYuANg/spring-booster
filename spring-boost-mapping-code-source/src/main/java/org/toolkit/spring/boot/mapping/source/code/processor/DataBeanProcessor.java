/* (C)2023*/
package org.toolkit.spring.boot.mapping.source.code.processor;

import com.google.common.collect.ImmutableTable;
import jakarta.annotation.PostConstruct;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.mapping.source.code.annotation.EnumMapping;
import org.toolkit.spring.boot.mapping.source.code.annotation.StaticGroup;

@Slf4j
public class DataBeanProcessor extends ClassPathScanningCandidateComponentProvider {
    public DataBeanProcessor() {
        super(false);
        addIncludeFilter(new AnnotationTypeFilter(StaticGroup.class));
        addIncludeFilter(new AnnotationTypeFilter(EnumMapping.class));
    }

    @Override
    protected boolean isCandidateComponent(@NotNull AnnotatedBeanDefinition beanDefinition) {
        return true;
    }
}
