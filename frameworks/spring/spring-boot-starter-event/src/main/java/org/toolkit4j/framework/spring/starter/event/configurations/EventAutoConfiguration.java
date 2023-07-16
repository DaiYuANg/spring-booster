package org.toolkit4J.framework.spring.starter.event.configurations;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.gson.Gson;
import org.quartz.Scheduler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit4J.framework.spring.starter.event.bus.BusPublisher;
import org.toolkit4J.framework.spring.starter.event.spring.SpringEventPublisher;
import org.toolkit4j.libs.thready.async.AsyncWorker;

import java.util.concurrent.ScheduledThreadPoolExecutor;

@AutoConfiguration
@EnableConfigurationProperties(EventConfigurationProperties.class)
public class EventAutoConfiguration {
    private final static String persistentName = "event";

    @Bean
    @ConditionalOnMissingBean(SpringEventPublisher.class)
    @ConditionalOnBean({AsyncWorker.class, Scheduler.class, ScheduledThreadPoolExecutor.class})
    public SpringEventPublisher eventPublisher() {
        return new SpringEventPublisher();
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

//    @Bean
//    public AsyncEventBus asyncEventBus() {
//        return new AsyncEventBus(MoreExecutors.directExecutor(), new EventSubscriberExceptionHandler());
//    }


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
