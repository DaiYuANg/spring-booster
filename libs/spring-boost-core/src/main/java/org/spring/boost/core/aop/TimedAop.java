package org.spring.boost.core.aop;

import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.text.StringSubstitutor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.annotation.Timed;

@Aspect
@Slf4j
@RequiredArgsConstructor
public class TimedAop {

  private final MethodCache methodCache = new MethodCache();

  @Pointcut("@annotation(org.spring.boost.core.annotation.Timed)")
  public void logExecutionTimeMethods() {
  }

  @Around("logExecutionTimeMethods()")
  public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    val method = methodCache.getMethod(joinPoint);

    val timed = method.getAnnotation(Timed.class);

    val unit = timed.unit();

    val logTemplate = timed.logTemplate();

    val stopwatch = Stopwatch.createStarted();

    val result = joinPoint.proceed();

    val elapsedTime = stopwatch.elapsed(unit);

    val valuesMap = ImmutableMap.of(
      Timed.Template.METHOD, joinPoint.getSignature().toString(),
      Timed.Template.TIME, String.valueOf(elapsedTime),
      Timed.Template.UNIT, unit.toString().toLowerCase()
    );

    val sub = new StringSubstitutor(valuesMap);

    val logMessage = sub.replace(logTemplate);

    echo(timed, logMessage);
    return result;
  }

  private void echo(@NotNull Timed timed, String logMessage) {
    switch (timed.level()) {
      case ERROR -> log.atError().log(logMessage);
      case WARN -> log.atWarn().log(logMessage);
      case INFO -> log.atInfo().log(logMessage);
      case DEBUG -> log.atDebug().log(logMessage);
      case TRACE -> log.atTrace().log(logMessage);
    }
  }
}
