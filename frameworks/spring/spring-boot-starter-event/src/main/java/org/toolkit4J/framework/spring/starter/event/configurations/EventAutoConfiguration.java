package org.toolkit4J.framework.spring.starter.event.configurations;

import cn.hutool.extra.spring.EnableSpringUtil;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.toolkit4J.framework.spring.starter.event.bus.BusPublisher;
import org.toolkit4J.framework.spring.starter.event.spring.AsyncEventPublisher;

@AutoConfiguration
@EnableConfigurationProperties(EventConfigurationProperties.class)
@EnableJms
@EnableSpringUtil
@EnableAsync
@EnableScheduling
public class EventAutoConfiguration {
    private final static String persistentName = "event";

    @Resource
    private TaskExecutor taskExecutor;

    @Bean
    @ConditionalOnMissingBean(AsyncEventPublisher.class)
//    @ConditionalOnBean({AsyncWorker.class, Scheduler.class, ScheduledThreadPoolExecutor.class})
    public AsyncEventPublisher eventPublisher() {
        return new AsyncEventPublisher();
    }
//
//    @Bean
//    @ConditionalOnMissingBean(EventBus.class)
//    @ConditionalOnClass(EventBus.class)
//    public EventBus eventBus() {
//        return new EventBus(new EventSubscriberExceptionHandler());
//    }

    @Bean
    public BusPublisher busPublisher() {
        return new BusPublisher();
    }

    @Bean
    public SimpleApplicationEventMulticaster simpleApplicationEventMulticaster() {
        val multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setTaskExecutor(taskExecutor);
        return multicaster;
    }

    @Bean
    @ConditionalOnMissingBean(Gson.class)
    @ConditionalOnClass(Gson.class)
    public Gson gson() {
        return new Gson();
    }

    @Bean
    public Cache<Long, Object> cache() {
        return Caffeine.newBuilder().build();
    }
}
