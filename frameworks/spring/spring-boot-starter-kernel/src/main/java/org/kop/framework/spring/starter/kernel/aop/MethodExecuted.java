package org.kop.framework.spring.starter.kernel.aop;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;
import org.kop.framework.spring.starter.kernel.events.EventPublisher;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MethodExecuted {
    @Resource
    private EventPublisher eventPublisher;

    @Pointcut("@annotation(org.kop.framework.spring.starter.kernel.annotations.MethodExecuted)")
    public void methodExecutedPointCut() {
    }

    @Around("methodExecutedPointCut()")
    public Object around(@NotNull ProceedingJoinPoint pjp) throws Throwable {
        var returned = pjp.proceed();
//        eventPublisher.publish(new MethodExecutedEvent(this, returned));
        return returned;
    }
}
