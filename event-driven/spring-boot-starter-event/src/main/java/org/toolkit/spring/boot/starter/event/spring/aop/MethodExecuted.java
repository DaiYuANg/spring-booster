package org.toolkit.spring.boot.starter.event.spring.aop;

import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.starter.event.spring.AsyncEventPublisher;

@Component
@Aspect
@Slf4j
public class MethodExecuted {
	@Resource
	private AsyncEventPublisher eventPublisher;

	@Pointcut("@annotation(org.toolkit.spring.boot.starter.event.spring.annotations.MethodExecuted)")
	public void methodExecutedPointCut() {}

	@SneakyThrows
	@Around("methodExecutedPointCut()")
	public Object around(@NotNull ProceedingJoinPoint pjp) {
		var returned = pjp.proceed();
		//		eventPublisher.publish(
		//				returned.equals(Void.TYPE) ? new NormalEvent(this) : new MethodExecutedEvent(this, returned));
		return returned;
	}
}