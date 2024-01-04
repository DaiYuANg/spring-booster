/* (C)2023*/
package org.toolkit.spring.boot.mapping.source.code.processor;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
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
