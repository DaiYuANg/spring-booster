package org.kop.framework.spring.aop;

import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.kop.framework.spring.events.EventPublisher;
import org.kop.framework.spring.events.MethodExecutedEvent;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MethodExecuted {
    @Resource
    private EventPublisher eventPublisher;

    @Pointcut("@annotation(org.kop.framework.spring.annotations.MethodExecuted)")
    public void methodExecutedPointCut() {
    }

    @SneakyThrows
    @Around("methodExecutedPointCut()")
    public Object around(ProceedingJoinPoint pjp) {
        var returned = pjp.proceed();
        eventPublisher.publish(new MethodExecutedEvent(this, returned));
        return returned;
    }
}
