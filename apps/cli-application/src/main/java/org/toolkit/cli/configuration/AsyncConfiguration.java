package org.toolkit.cli.configuration;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@Slf4j
@EnableAsync
@EnableScheduling
public class AsyncConfiguration {

	private final Integer systemCode = Runtime.getRuntime().availableProcessors();

	@Bean
	@Primary
	public ThreadPoolTaskExecutor threadPoolExecutor() {
		val threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(systemCode);
		threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		threadPoolTaskExecutor.setThreadNamePrefix("AsyncWorker-");
		threadPoolTaskExecutor.setMaxPoolSize(systemCode * 2 + 1);
		threadPoolTaskExecutor.setKeepAliveSeconds(60);
		threadPoolTaskExecutor.setQueueCapacity(systemCode * 2 + 1);
		threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		return threadPoolTaskExecutor;
	}

	@Bean
	public ScheduledThreadPoolExecutor scheduledThreadPoolExecutor() {
		return new ScheduledThreadPoolExecutor(
				systemCode + 1,
				new ThreadFactoryBuilder()
						.setNameFormat("schedule-%d")
						.setDaemon(true)
						.build(),
				new ThreadPoolExecutor.CallerRunsPolicy());
	}
}
