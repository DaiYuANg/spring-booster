package org.kop.framework.spring.starter.event.configurations;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.kop.framework.spring.boot.starter.async.AsyncWorkerAutoConfiguration;
import org.kop.framework.spring.boot.starter.async.AsyncWorkerProperties;
import org.kop.framework.spring.boot.starter.scheduled.configuration.ScheduledAutoConfiguration;
import org.kop.framework.spring.starter.event.spring.SpringEventPublisher;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@Slf4j
@AutoConfigureAfter({AsyncWorkerAutoConfiguration.class, ScheduledAutoConfiguration.class})
public class SpringEventAutoConfiguration {
    @Resource
    private AsyncWorkerProperties asyncWorkerProperties;

    @Resource
    private AsyncWorkerAutoConfiguration asyncWorkerAutoConfiguration;

    @Bean
    @ConditionalOnMissingBean
    public SpringEventPublisher eventPublisher() {
        val ep = new SpringEventPublisher();
        log.info("event publish init finish");
        return ep;
    }
}
