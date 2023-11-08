package org.toolkit.spring.boot.starter.restful.global;

import jakarta.annotation.PostConstruct;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.toolkit.spring.boot.starter.restful.annotations.IgnoreResponseAdvice;
import org.toolkit.spring.boot.starter.restful.structure.Response;

import java.util.Objects;

@ControllerAdvice
@Slf4j
public class ResponseHandler implements ResponseBodyAdvice<Object> {
    @PostConstruct
    public void init() {
        log.info("init response handler");
    }

    @Override
    public boolean supports(
            @NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        val isMethodIgnore = Objects.nonNull(returnType.getMethodAnnotation(IgnoreResponseAdvice.class));
        val isControllerIgnore = returnType.getContainingClass().isAnnotationPresent(IgnoreResponseAdvice.class);
        val isResponse = returnType.getContainingClass() == Response.class;
        return isControllerIgnore && isMethodIgnore && isResponse;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(
            Object body,
            @NotNull MethodParameter returnType,
            @NotNull MediaType selectedContentType,
            @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
            @NotNull ServerHttpRequest request,
            @NotNull ServerHttpResponse response) {
        return processBody(body);
    }

    @SneakyThrows
    private Object processBody(Object body) {
        return body == null ? Response.success() : Response.success(body);
    }
}
