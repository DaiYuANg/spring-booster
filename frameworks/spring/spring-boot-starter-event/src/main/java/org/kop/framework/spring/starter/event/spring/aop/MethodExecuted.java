package org.kop.framework.spring.starter.event.spring.aop;

import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.starter.event.spring.SpringEventPublisher;
import org.kop.framework.spring.starter.event.spring.base.MethodExecutedEvent;
import org.kop.framework.spring.starter.event.spring.base.NormalEvent;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MethodExecuted {
    @Resource
    private SpringEventPublisher eventPublisher;

    @Pointcut("@annotation(org.kop.framework.spring.starter.event.spring.annotations.MethodExecuted)")
    public void methodExecutedPointCut() {
    }

    @SneakyThrows
    @Around("methodExecutedPointCut()")
    public Object around(@NotNull ProceedingJoinPoint pjp) {
        var returned = pjp.proceed();
        eventPublisher.publish(returned.equals(Void.TYPE) ?
                new NormalEvent(this) :
                new MethodExecutedEvent(this, returned));
        return returned;
    }
}
