/* (C)2023*/
package org.spring.boost.common.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.spring.boost.common.api.BeanRegistry;
import org.spring.boost.common.context.BeanRegistryImpl;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@Slf4j
public class SpringBootUtilAutoConfiguration {
	@Bean
	public BeanRegistry beanRegistry(ApplicationContext context, DefaultListableBeanFactory listableBeanFactory) {
		return BeanRegistryImpl.builder()
				.context(context)
				.listableBeanFactory(listableBeanFactory)
				.build();
	}
}
