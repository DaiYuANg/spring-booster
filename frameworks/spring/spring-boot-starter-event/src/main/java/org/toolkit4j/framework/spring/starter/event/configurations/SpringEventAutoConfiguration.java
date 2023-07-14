package org.toolkit4j.framework.spring.starter.event.configurations;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.toolkit4j.framework.spring.boot.starter.async.config.AsyncWorkerAutoConfiguration;
import org.toolkit4j.framework.spring.boot.starter.scheduled.configuration.ScheduledAutoConfiguration;
import org.toolkit4j.framework.spring.starter.event.spring.SpringEventPublisher;

@AutoConfiguration
@Slf4j
@AutoConfigureAfter({AsyncWorkerAutoConfiguration.class, ScheduledAutoConfiguration.class})
public class SpringEventAutoConfiguration {
	@Bean
	@ConditionalOnMissingBean
	public SpringEventPublisher eventPublisher() {
		val ep = new SpringEventPublisher();
		log.info("event publish init finish");
		return ep;
	}
}
