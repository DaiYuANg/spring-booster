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
    AsyncWorker asyncWorker;
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

    //todo into database
//    @SneakyThrows
//    public <E extends EventOfSpring<T>, T, J extends Job> void persistenceDelayPublish(E event, J job, long delay, TimeUnit timeUnit) {
//        scheduler.start();
//        var detail = JobBuilder.newJob(job.getClass()).build();
//        var scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
//        var trigger = TriggerBuilder.newTrigger().withSchedule(scheduleBuilder).build();
//        scheduler.scheduleJob(detail, trigger);
//    }
}