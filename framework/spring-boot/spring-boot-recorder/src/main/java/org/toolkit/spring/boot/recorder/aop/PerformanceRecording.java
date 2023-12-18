/* (C)2023*/
package org.toolkit.spring.boot.recorder.aop;

import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.StopWatch;

// @Aspect
@Slf4j
// @Component
public class PerformanceRecording {
	@Resource
	private StopWatch watcher;

	@Pointcut("@annotation(org.toolkit4j.framework.spring.boot.starter.recording.annotation.PerformanceRecorder)")
	public void performance() {}

	@SneakyThrows
	@Around("performance()")
	public Object performance(@NotNull ProceedingJoinPoint pjp) {
		watcher.start(pjp.getSignature().getName());
		val obj = pjp.proceed();
		watcher.stop();
		return obj;
	}
}
