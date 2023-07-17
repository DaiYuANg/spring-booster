package org.toolkit4J.framework.spring.starter.event.spring;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.quartz.Scheduler;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.toolkit4J.framework.spring.boot.starter.async.base.AsyncWorker;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class SpringEventPublisher {
	@Resource
	private AsyncWorker asyncWorker;

	@Resource
	private Scheduler scheduler;

	@Resource
	private ApplicationEventPublisher applicationEventPublisher;

	@Resource
	private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

	public <E extends ApplicationEvent> void publish(E event) {
		applicationEventPublisher.publishEvent(event);
		printLog(event);
	}

	public <E extends ApplicationEvent> void simpleDelayPublish(E event, long delay, TimeUnit timeUnit) {
		val task = scheduledThreadPoolExecutor.schedule(() -> publish(event), delay, timeUnit);
		if (task.isDone()) printLog(event);
	}

	public <E extends ApplicationEvent> void fixRatePublish(Runnable runnable, long rate, long p, TimeUnit timeUnit) {
		scheduledThreadPoolExecutor.scheduleAtFixedRate(runnable, rate, p, timeUnit);
	}

	public <E extends ApplicationEvent> void asyncPublish(E event) {
		asyncWorker.run(() -> publish(event)).thenRun(() -> printLog(event));
	}

	private void printLog(ApplicationEvent event) {
		if (log.isInfoEnabled()) log.info("event:{} has published", event);
		if (log.isDebugEnabled()) log.debug("event:{} has published", event);
		if (log.isTraceEnabled()) log.trace("event:{} has published", event);
	}
}
