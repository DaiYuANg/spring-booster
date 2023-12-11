package org.toolkit.spring.boot.cache.bean;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

@Slf4j
public class CacheBeanProcessor implements InstantiationAwareBeanPostProcessor {

	@Override
	public PropertyValues postProcessProperties(
			@NotNull PropertyValues pvs, @NotNull Object bean, @NotNull String beanName) throws BeansException {
		pvs.forEach(r -> {});
		return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
	}
}
