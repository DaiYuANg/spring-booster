package org.kop.framework.spring.boot.starter.scheduled.configuration;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@AutoConfiguration
@EnableConfigurationProperties(ScheduledConfigurationProperties.class)
@Slf4j
@EnableScheduling
public class ScheduledAutoConfiguration {

    @Resource
    private ScheduledConfigurationProperties scheduledConfigurationProperties;

//    @SneakyThrows
//    @Bean
//    @ConditionalOnMissingBean
//    public ScheduledThreadPoolExecutor scheduledThreadPoolExecutor() {
////        val scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(
////                scheduledConfigurationProperties.getCoreSize(),
////                new ThreadFactoryBuilder().setNameFormat(scheduledConfigurationProperties.getDefaultScheduledNamePrefix()).build(),
////                new ThreadPoolExecutor.CallerRunsPolicy()
////        );
////        if (scheduledConfigurationProperties.isPreheat()) scheduledThreadPoolExecutor.prestartAllCoreThreads();
////        log.info("configure ScheduledThreadPoolExecutor successful");
////        return scheduledThreadPoolExecutor;
//    }
}
