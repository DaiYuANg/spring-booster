/* (C)2023*/
package org.toolkit.spring.boot.cache.aop;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;
// import org.toolkit.spring.boot.cache.annotation.Cached;

@Aspect
@Slf4j
@Component
public class CachedProcessor {
	@Resource
	private SpelExpressionParser parser;

	//	@SneakyThrows
	//	@Around("@annotation(org.toolkit.spring.boot.cache.annotation.Cached)")
	//	public Object process(@NotNull ProceedingJoinPoint pjp) {
	//		val method = (MethodSignature) pjp.getSignature();
	//		val annotation = method.getMethod().getAnnotation(Cached.class);
	//		val result = pjp.proceed();
	//		parser.parseExpression(annotation.key()).getValue();
	//		return result;
	//	}
}
