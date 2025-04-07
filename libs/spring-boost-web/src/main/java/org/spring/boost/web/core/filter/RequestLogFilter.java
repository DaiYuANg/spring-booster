package org.spring.boost.web.core.filter;

import cn.hutool.extra.servlet.ServletUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
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
public class RequestLogFilter extends CommonsRequestLoggingFilter {

  @Override
  protected boolean shouldLog(@NotNull HttpServletRequest request) {
    return this.logger.isInfoEnabled();
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
