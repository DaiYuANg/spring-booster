/* (C)2024*/
package org.spring.boost.office.response;

import jakarta.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.office.annotation.ExcelDownloadResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ExcelDownloadResponseAdvice implements ResponseBodyAdvice<Collection<Object>> {
    @Override
    public boolean supports(
            @NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.hasMethodAnnotation(ExcelDownloadResponse.class);
    }

    @Override
    public Collection<Object> beforeBodyWrite(
            Collection<Object> body,
            @NotNull MethodParameter returnType,
            @NotNull MediaType selectedContentType,
            @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
            @NotNull ServerHttpRequest request,
            @NotNull ServerHttpResponse response) {
        val resp = (HttpServletResponse) response;
        resp.reset();
        resp.setContentType("application/vnd.ms-excel");
        resp.setHeader("Content-disposition", "attachment;filename=user_excel_" + System.currentTimeMillis() + ".xlsx");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        return null;
    }
}
