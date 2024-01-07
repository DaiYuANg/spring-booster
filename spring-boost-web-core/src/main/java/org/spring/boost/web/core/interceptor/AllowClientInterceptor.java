/* (C)2023*/
package org.spring.boost.web.core.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.web.core.annotation.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Interceptor
public class AllowClientInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(
            @NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) {
//        if (!(handler instanceof HandlerMethod handlerMethod)) {
//            return true;
//        }
//        val method = handlerMethod.getMethod();
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
