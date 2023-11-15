package org.toolkit.spring.boot.website.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class LanguageInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(
            @NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler)
            throws Exception {
        String language = request.getHeader("Accept-Language");
        log.info("language:{}", language);
        if (language != null && language.startsWith("en")) {
            response.sendRedirect("/en/index.html");
        } else if (language != null && language.startsWith("es")) {
            response.sendRedirect("/zh/index.html");
        }

        return true;
    }
}
