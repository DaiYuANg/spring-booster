package org.toolkit4j.framework.spring.boot.starter.async.bean;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class AsyncBeanFactory extends DefaultListableBeanFactory {
	AsyncBeanFactory(ConfigurableListableBeanFactory beanFactory) {}

	@Override
	protected Object resolveBeforeInstantiation(String beanName, RootBeanDefinition mbd) {
		return super.resolveBeforeInstantiation(beanName, mbd);
	}

	@Override
	protected void invokeInitMethods(@NotNull String beanName, @NotNull Object bean, RootBeanDefinition mbd)
			throws Throwable {
		boolean isInitializingBean = (bean instanceof InitializingBean);
		if ((!isInitializingBean || (mbd != null && mbd.isExternallyManagedInitMethod("afterPropertiesSet")))
				&& !(bean instanceof InitializingBean)) {
			return;
		}
		((InitializingBean) bean).afterPropertiesSet();
	}
}
