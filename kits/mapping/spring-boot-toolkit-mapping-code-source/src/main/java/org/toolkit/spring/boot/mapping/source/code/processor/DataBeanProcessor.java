package org.toolkit.spring.boot.mapping.source.code.processor;

import com.google.common.collect.ImmutableTable;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

@RequiredArgsConstructor
@Slf4j
public class DataBeanProcessor implements BeanDefinitionRegistryPostProcessor {

	@NonNull private final ImmutableTable<String, String, Object> staticTable;

	@Override
	public void postProcessBeanDefinitionRegistry(@NotNull BeanDefinitionRegistry registry) throws BeansException {
		if (registry instanceof DefaultListableBeanFactory beanFactory) {
			beanFactory.registerSingleton("staticTable", staticTable);
		}
	}
}
