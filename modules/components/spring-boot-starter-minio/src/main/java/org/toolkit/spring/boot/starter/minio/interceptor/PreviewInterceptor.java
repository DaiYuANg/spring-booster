package org.toolkit.spring.boot.starter.minio.interceptor;

import cn.hutool.http.useragent.UserAgentParser;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.toolkit.spring.boot.starter.minio.configurations.properties.MinioConfigurationProperties;
import org.toolkit.spring.boot.starter.minio.service.IMinioUploadService;
import org.toolkit.spring.boot.starter.minio.vo.PreviewVo;

import java.util.Map;

@Slf4j
@Component
public class PreviewInterceptor implements HandlerInterceptor {

    @Resource
    private ApplicationEventPublisher eventPublisher;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) {

        return true;
    }
}
