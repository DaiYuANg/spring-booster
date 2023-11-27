package org.toolkit.spring.boot.mapping.web.handler;

import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.toolkit.spring.boot.mapping.web.util.ObjectUtil;

@ControllerAdvice
@Order
@Aspect
@Slf4j
public class MappedResponseHandler {

	@Resource
	private ByteBuddy byteBuddy;

	@Pointcut("@annotation(org.toolkit.spring.boot.mapping.core.annotations.MappingTarget)")
	public void annotationPoint() {}

	@SneakyThrows
	@Around("annotationPoint()")
	public Object before(@NotNull ProceedingJoinPoint joinPoint) {
		val returnValue = joinPoint.proceed();
		processNestedType(returnValue);
		return returnValue;
	}

	@SneakyThrows
	@Contract(pure = true)
	private void processNestedType(@NotNull Object returnValue) {
		returnValue.getClass().getNestMembers();
		val clazz = returnValue.getClass();
		if (returnValue instanceof Page<?> v) {
			v.getContent().forEach(item -> ObjectUtil.walkObject(item, 10));
		}
		try (DynamicType.Unloaded<?> dynamicType = byteBuddy
				.subclass(Object.class)
				.method(ElementMatchers.named("toString"))
				.intercept(FixedValue.value("Hello World!"))
				.make()) {
			val newClazz = dynamicType.load(getClass().getClassLoader()).getLoaded();
			val newObject = newClazz.getDeclaredConstructor().newInstance();
			System.err.println(newObject);
		}
	}
}
