/* (C)2023*/
package org.spring.boost.web.core.interceptor;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.web.core.configurations.WebConfigurationProperties;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
public class LimitSubmissionInterceptor implements HandlerInterceptor {
  @Resource
  private WebConfigurationProperties webConfigurationProperties;

  @Override
  public boolean preHandle(
    @NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler)
    throws Exception {
    return HandlerInterceptor.super.preHandle(request, response, handler);
  }

  @Override
  public void afterCompletion(
    @NotNull HttpServletRequest request,
    @NotNull HttpServletResponse response,
    @NotNull Object handler,
    Exception ex)
    throws Exception {
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }
}
