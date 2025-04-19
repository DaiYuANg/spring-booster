package org.spring.boost.web.core.filter;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.web.core.configurations.WebConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

/**
 * 请求日志打印过滤器
 *
 * @author haoxr
 * @since 2023/03/03
 */
@Configuration
@Slf4j
@RequiredArgsConstructor
public class RequestLogFilter extends CommonsRequestLoggingFilter {

  private final WebConfigurationProperties webConfigurationProperties;

  @Override
  protected boolean shouldLog(@NotNull HttpServletRequest request) {
    return this.logger.isInfoEnabled() && webConfigurationProperties.getEnabledRequestLog();
  }

  @Override
  protected void beforeRequest(@NotNull HttpServletRequest request, @NotNull String message) {
    val requestURI = request.getRequestURI();
    val ip = request.getRemoteAddr();
    log.atInfo().log("request,ip:{}, uri: {}", ip, requestURI);
    super.beforeRequest(request, message);
  }

  @Override
  protected void afterRequest(@NotNull HttpServletRequest request, @NotNull String message) {
    super.afterRequest(request, message);
  }
}
