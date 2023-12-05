package org.toolkit.spring.boot.mapping.web.handler;

import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.GenericTypeResolver;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.toolkit.spring.boot.mapping.web.util.ObjectUtil;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@ControllerAdvice
@Order
@Aspect
@Slf4j
public class MappedResponseHandler {

    @Resource
    private ByteBuddy byteBuddy;

    private static final ConcurrentMap<String, Thread> async = new ConcurrentHashMap<>();

    @Pointcut("@annotation(org.toolkit.spring.boot.mapping.core.annotations.MappingTarget)")
    public void annotationPoint() {
    }

    @Before("annotationPoint()")
    public void before(@NotNull JoinPoint joinPoint) {
        val signature = (MethodSignature) joinPoint.getSignature();
        val method = signature.getMethod();
        val returnClass = method.getReturnType();
        val task = Thread.ofVirtual().start(() -> {
            System.err.println(Arrays.toString(method.getReturnType().getNestMembers()));
            System.err.println(GenericTypeResolver.resolveReturnTypeArgument(method,joinPoint.getTarget().getClass()));
            System.err.println(Arrays.toString(returnClass.getGenericInterfaces()));
            System.err.println(returnClass.getGenericSuperclass());
        });
    }

    @SneakyThrows
    @Around("annotationPoint()")
    public Object around(@NotNull ProceedingJoinPoint joinPoint) {
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
        }
    }
}
