package org.toolkit4J.framework.spring.starter.event.spring;

import cn.hutool.core.util.IdUtil;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.stereotype.Component;
import org.toolkit4J.framework.spring.starter.event.spring.exceptions.EventAlreadyPublished;

import java.time.Duration;
import java.time.temporal.TemporalUnit;
import java.util.Objects;
import java.util.concurrent.*;

@Slf4j
@Component
public class ScheduleEventPublisher {
    @Resource
    private TaskScheduler taskScheduler;

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @Getter
    private final ConcurrentMap<String, ScheduledFuture<?>> scheduledEvents = new ConcurrentHashMap<>();

    public <E extends ApplicationEvent> String delayPublish(String eventId, E event, long delay, TemporalUnit timeUnit) {
        val future = taskScheduler.schedule(() -> {
            applicationEventPublisher.publishEvent(event);
            scheduledEvents.remove(eventId);
        }, new PeriodicTrigger(Duration.of(delay, timeUnit)));
        scheduledEvents.put(eventId, future);
        return eventId;
    }

    public <E extends ApplicationEvent> String delayPublish(E event, long delay, TemporalUnit timeUnit) {
        val id = IdUtil.fastSimpleUUID();
        return delayPublish(id, event, delay, timeUnit);
    }

    public <E extends ApplicationEvent> void fixRatePublish(Runnable runnable, long rate, long p, TimeUnit timeUnit) {
//        taskScheduler.scheduleWithFixedDelay(runnable,rate,p);

//		scheduledThreadPoolExecutor.scheduleAtFixedRate(runnable, rate, p, timeUnit);
    }

    public void cancelSchedulerEvent(String eventId) {
        val event = scheduledEvents.get(eventId);
        if (Objects.isNull(event)) throw new EventAlreadyPublished();
        event.cancel(false);
    }
}
