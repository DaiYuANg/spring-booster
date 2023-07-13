package org.toolkit4j.framework.spring.starter.monitor.interceptors;

import cn.hutool.http.useragent.UserAgentParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

@Slf4j
public class AccessInterceptor implements HandlerInterceptor {

    private final static String USER_AGENT = "user-agent";

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) {
        val agentText = request.getHeader(USER_AGENT);
        if (Objects.isNull(agentText) || agentText.equals(agentText.intern()))return;
        val agent = UserAgentParser.parse(agentText);
    }
}
