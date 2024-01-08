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
import org.springframework.http.HttpHeaders;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

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
        UserAgentParser.parse(agent).isMobile();
        //        val ann = method.getAnnotation(AllowClient.class);
//
//        if (Objects.isNull(ann) || ann.device() == ClientDevice.ALL) {
//            return true;
//        }
//
//        val isMobile = UserAgentParser.parse(request.getHeader("user-agent")).isMobile();
//        if (isMobile && ann.device() == ClientDevice.MOBILE) {
//            return true;
//        }
//
//        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
        return false;
    }
}
