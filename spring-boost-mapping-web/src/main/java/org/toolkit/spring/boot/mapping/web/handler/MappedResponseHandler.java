/* (C)2023*/
package org.toolkit.spring.boot.mapping.web.handler;

import jakarta.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.bytebuddy.ByteBuddy;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
@Order
@Aspect
@Slf4j
public class MappedResponseHandler {

    @Resource
    private ByteBuddy byteBuddy;

    //	@Resource
    //	private IMappingService mappingService;

    private static final ConcurrentMap<String, Thread> async = new ConcurrentHashMap<>();

    @Pointcut("@annotation(org.toolkit.spring.boot.mapping.base.annotation.MappingTarget)")
    public void annotationPoint() {}

    @Before("annotationPoint()")
    public void before(@NotNull JoinPoint joinPoint) {
        //		val signature = (MethodSignature) joinPoint.getSignature();
        //		val method = signature.getMethod();
        //		val mappingTargetAnnotation = method.getAnnotation(MappingTarget.class);
        //		val pretreatment = mappingTargetAnnotation.pretreatment();
        //		if (pretreatment.equals(MappingTarget.class)) return;
        //
        //		Arrays.stream(pretreatment.getDeclaredFields()).forEach(field -> {
        //			field.setAccessible(true);
        //			System.err.println(field);
        //		});
        //		System.err.println(Arrays.stream(pretreatment.getNestMembers()).toList());
        //        val returnClass = method.getReturnType();
        //        val typeToken = new TypeToken<>(returnClass){};
    }

    @SneakyThrows
    @Around("annotationPoint()")
    public Object around(@NotNull ProceedingJoinPoint joinPoint) {
        val returnValue = joinPoint.proceed();
        //        processNestedType(returnValue);
        return returnValue;
    }

    @Contract(pure = true)
    private void processNestedType(@NotNull Object returnValue) {

        //        returnValue.getClass().getNestMembers();
        //        val clazz = returnValue.getClass();
        //        if (returnValue instanceof Page<?> v) {
        //            v.getContent().forEach(item -> ObjectUtil.walkObject(item, 10));
        //        }
        //        try (DynamicType.Unloaded<?> dynamicType = byteBuddy
        //                .subclass(Object.class)
        //                .method(ElementMatchers.named("toString"))
        //                .intercept(FixedValue.value("Hello World!"))
        //                .make()) {
        //            val newClazz = dynamicType.load(getClass().getClassLoader()).getLoaded();
        //            val newObject = newClazz.getDeclaredConstructor().newInstance();
        //        }
    }
}
