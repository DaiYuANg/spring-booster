package org.toolkit.spring.boot.starter.monitor.interceptors;

import cn.hutool.http.useragent.UserAgentParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class AccessInterceptor implements HandlerInterceptor {

	private static final String USER_AGENT = "user-agent";

	@Override
	public void postHandle(
			@NotNull HttpServletRequest request,
			@NotNull HttpServletResponse response,
			@NotNull Object handler,
			ModelAndView modelAndView) {
		val agentText = request.getHeader(USER_AGENT);
		if (Objects.isNull(agentText) || agentText.equals(agentText.intern())) return;
		val agent = UserAgentParser.parse(agentText);
	}
}
