package org.spring.boost.core.aop;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.aspectj.lang.ProceedingJoinPoint;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Slf4j
public class MethodCache {
  private final ConcurrentMap<String, Method> methodCache = new ConcurrentHashMap<>();

  public Method getMethod(@NotNull ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
    val key = generateKey(joinPoint);

    if (methodCache.containsKey(key)) {
      return methodCache.get(key);
    }

    val methodName = joinPoint.getSignature().getName();
    val targetClass = joinPoint.getTarget().getClass();

    val method = Arrays
      .stream(targetClass.getDeclaredMethods())
      .filter(m -> m.getName().equals(methodName) && Arrays.equals(m.getParameterTypes(), joinPoint.getArgs()))
      .findFirst()
      .orElseThrow(() -> new NoSuchMethodException("Method " + methodName + " not found"));

    methodCache.put(key, method);
    return method;
  }

  // 生成缓存 key，结合方法名和参数类型
  private @NotNull String generateKey(@NotNull ProceedingJoinPoint joinPoint) {
    val methodName = joinPoint.getSignature().getName();
    val parameterTypes = Arrays.toString(joinPoint.getArgs());
    return methodName + parameterTypes;
  }
}
