package org.toolkit.spring.boot.mapped.aop;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.mapped.utils.MappedUtil;

@Aspect
@Component
@Slf4j
public class NeedMappedProcessor {

	@Pointcut("@annotation(org.toolkit.spring.boot.mapped.annotations.NeedMapped)")
	public void needMappedPointCut() {}

	@SneakyThrows
	@Around("needMappedPointCut()")
	public Object process(@NotNull ProceedingJoinPoint pjp) {
		val object = pjp.proceed();
		if (MappedUtil.isMappedTarget(object.getClass())) return object;
		log.info("something");
		return object;
	}
}
