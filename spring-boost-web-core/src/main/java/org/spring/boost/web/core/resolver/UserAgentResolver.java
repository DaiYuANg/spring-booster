/* (C)2023*/
package org.spring.boost.web.core.resolver;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentParser;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Slf4j
public class UserAgentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(@NotNull MethodParameter parameter) {
        return UserAgent.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(
            @NotNull MethodParameter parameter,
            ModelAndViewContainer mavContainer,
            @NotNull NativeWebRequest webRequest,
            WebDataBinderFactory binderFactory) {
        val request = (HttpServletRequest) webRequest.getNativeRequest();
        val userAgentString = request.getHeader(HttpHeaders.USER_AGENT);
        return UserAgentParser.parse(userAgentString);
    }
}
