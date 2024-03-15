/* (C)2023*/
package org.spring.boost.core.autoconfigure;

import io.github.classgraph.ClassGraph;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.api.BeanRegistry;
import org.spring.boost.core.context.SimpleBeanRegistry;
import org.spring.boost.core.listener.ContextRefreshListener;
import org.spring.boost.core.listener.StartUpListener;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties(CoreConfigurationProperties.class)
@RequiredArgsConstructor
public class CoreAutoConfiguration {

    @Bean
    BeanRegistry beanRegistry(ApplicationContext context, DefaultListableBeanFactory listableBeanFactory) {
        return SimpleBeanRegistry.builder()
                .context(context)
                .beanFactory(listableBeanFactory)
                .build();
    }

    @Bean
    ClassGraph classGraph(@NotNull CoreConfigurationProperties properties) {
        val config = properties.getClassScanner();
        val cg = new ClassGraph();
        if (config.getEnableClassGraphLog()) cg.enableRealtimeLogging();
        cg.verbose(config.getVerbose());
        return cg;
    }

    @Bean
    StartUpListener startUpListener(Environment environment) {
        return new StartUpListener(environment);
    }

    @Bean
    ContextRefreshListener contextReadyListener(BeanRegistry beanRegistry, ClassGraph classGraph) {
        return new ContextRefreshListener(classGraph, beanRegistry);
    }
}
