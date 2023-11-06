package org.toolkit.spring.boot.starter.mapped.handler;

import cn.hutool.core.collection.CollUtil;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.toolkit.spring.boot.starter.mapped.annotations.Mapping;

import java.lang.reflect.Field;
import java.util.Arrays;

@ControllerAdvice
@Order(0)
public class MappedResponseHandler implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(
            @NotNull MethodParameter returnType,
            @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        val clazz = returnType.getParameterType();
        // 使用反射获取类中的字段
        val fields = Arrays
                .stream(clazz.getDeclaredFields())
                .peek(field -> field.setAccessible(true))
                .filter(field -> field.isAnnotationPresent(Mapping.class))
                .toList();
        return CollUtil.isNotEmpty(fields);
    }

    @Override
    public Object beforeBodyWrite(
            Object body,
            @NotNull MethodParameter returnType,
            @NotNull MediaType selectedContentType,
            @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
            @NotNull ServerHttpRequest request,
            @NotNull ServerHttpResponse response) {

        return null;
    }
}
