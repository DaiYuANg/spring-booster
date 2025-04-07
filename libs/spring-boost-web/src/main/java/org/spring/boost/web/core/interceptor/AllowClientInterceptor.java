/* (C)2023*/
package org.spring.boost.web.core.interceptor;

import cn.hutool.http.useragent.UserAgentParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.web.core.annotation.Interceptor;
import org.spring.boost.web.core.annotation.OnlyDesktop;
import org.spring.boost.web.core.annotation.OnlyMobile;
import org.springframework.http.HttpHeaders;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Interceptor
@RequiredArgsConstructor
public class AllowClientInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(
    @NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) {
    if (!(handler instanceof HandlerMethod handlerMethod)) {
      return true;
    }
    val method = handlerMethod.getMethod();
    val agent = request.getHeader(HttpHeaders.USER_AGENT);
    val isMobile = UserAgentParser.parse(agent).isMobile();
    val onlyDesktop = Optional.ofNullable(method.getAnnotation(OnlyDesktop.class));
    val onlyMobile = Optional.ofNullable(method.getAnnotation(OnlyMobile.class));

    if (onlyMobile.isPresent() && isMobile) {
      return true;
    }

    if (onlyDesktop.isPresent() && isMobile) {
      response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
      return false;
    }
    return false;
  }
}
