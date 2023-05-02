package org.kop.framework.spring.events;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.daiyuang.libs.thready.async.AsyncWorker;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class EventPublisher {
    @Resource
    private AsyncWorker asyncWorker;
    @Resource
    private ApplicationEventPublisher applicationEventPublisher;
//    private final ScheduledThreadPoolExecutor = ThreadUtil.createDefaultScheduledThreadPoolExecutor(this.getClass());

    public <E extends AbstractEvent<T>, T> void publish(E event) {
        applicationEventPublisher.publishEvent(event);
    }

    public <E extends AbstractEvent<T>, T> void simpleDelayPublish(E event, long delay, TimeUnit timeUnit) {
//        scheduledThreadPoolExecutor.schedule(() -> publish(event), delay, timeUnit);
    }

    public <E extends AbstractEvent<T>, T> void asyncPublish(E event) {
        asyncWorker.run(() -> publish(event));
    }
}