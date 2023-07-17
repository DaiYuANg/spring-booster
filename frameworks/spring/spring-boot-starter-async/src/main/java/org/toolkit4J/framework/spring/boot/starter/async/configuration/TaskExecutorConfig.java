package org.toolkit4J.framework.spring.boot.starter.async.configuration;

import jakarta.annotation.Resource;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@EnableAsync // 开启异步配置
@Configuration
public class TaskExecutorConfig implements AsyncConfigurer {
	@Resource
	private ThreadPoolExecutor executor;

	@Override
	public Executor getAsyncExecutor() {
		return executor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return new SimpleAsyncUncaughtExceptionHandler();
	}
}
