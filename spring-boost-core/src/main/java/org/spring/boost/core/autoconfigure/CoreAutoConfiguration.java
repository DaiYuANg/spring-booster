/* (C)2023*/
package org.spring.boost.core.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.spring.boost.core.api.BeanRegistry;
import org.spring.boost.core.context.SimpleBeanRegistry;
import org.spring.boost.core.listener.StartUpListener;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@AutoConfiguration
@Slf4j
public class CoreAutoConfiguration {
    @Bean
    public BeanRegistry beanRegistry(ApplicationContext context, DefaultListableBeanFactory listableBeanFactory) {
        return SimpleBeanRegistry.builder()
                .context(context)
                .beanFactory(listableBeanFactory)
                .build();
    }

    @Bean
    public StartUpListener startUpListener(Environment environment) {
        return new StartUpListener(environment);
    }
}
