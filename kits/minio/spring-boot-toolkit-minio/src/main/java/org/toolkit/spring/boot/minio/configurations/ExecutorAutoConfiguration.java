package org.toolkit.spring.boot.minio.configurations;

import jakarta.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.toolkit.spring.boot.minio.configurations.properties.MinioThreadPoolTaskConfigurationProperties;

@AutoConfiguration
@EnableConfigurationProperties(MinioThreadPoolTaskConfigurationProperties.class)
@Slf4j
public class ExecutorAutoConfiguration {

	@Resource
	private MinioThreadPoolTaskConfigurationProperties configurationProperties;

	@Bean(name = "ToolkitMinioThreadPool")
	public ThreadPoolTaskExecutor threadPoolExecutor() {
		val threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(configurationProperties.getCoreSize());
		threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		threadPoolTaskExecutor.setThreadNamePrefix(configurationProperties.getPrefix());
		threadPoolTaskExecutor.setMaxPoolSize(configurationProperties.getMaxSize());
		threadPoolTaskExecutor.setKeepAliveSeconds(configurationProperties.getKeepAliveSeconds());
		threadPoolTaskExecutor.setQueueCapacity(configurationProperties.getQueueCapacity());
		threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
		return threadPoolTaskExecutor;
	}
}
