package org.toolkit4j.framework.spring.boot.starter.restful.aop;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.toolkit4j.framework.spring.boot.starter.restful.configurations.SSEConfigurationProperties;

@Aspect
@Slf4j
public class SSEAspect {
    @Resource
    private SSEConfigurationProperties sseConfigurationProperties;

    @Around("@annotation(org.toolkit4j.framework.spring.boot.starter.restful.annotations.EventSource)")
    public Object doSSEResponse(ProceedingJoinPoint pjp) {
        val emitter = new SseEmitter();



        return emitter;
    }
}
