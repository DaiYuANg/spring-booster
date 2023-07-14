package org.toolkit4j.framework.spring.boot.starter.scheduled.configuration;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import jakarta.annotation.Resource;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@AutoConfiguration
@EnableConfigurationProperties(ScheduledConfigurationProperties.class)
@Slf4j
@EnableScheduling
public class ScheduledAutoConfiguration {

	@Resource
	private ScheduledConfigurationProperties scheduledConfigurationProperties;

	@SneakyThrows
	@Bean
	public ScheduledThreadPoolExecutor scheduledThreadPoolExecutor() {
		val scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(
				scheduledConfigurationProperties.getCoreSize(),
				new ThreadFactoryBuilder()
						.setNameFormat(scheduledConfigurationProperties.getDefaultScheduledNamePrefix())
						.build(),
				new ThreadPoolExecutor.CallerRunsPolicy());
		if (scheduledConfigurationProperties.isPreheat()) scheduledThreadPoolExecutor.prestartAllCoreThreads();
		log.info("configure ScheduledThreadPoolExecutor successful");
		return scheduledThreadPoolExecutor;
	}
}
