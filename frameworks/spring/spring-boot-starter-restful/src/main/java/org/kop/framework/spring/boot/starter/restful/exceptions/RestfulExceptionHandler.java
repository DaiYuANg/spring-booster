package org.kop.framework.spring.boot.starter.restful.exceptions;

import org.jetbrains.annotations.NotNull;
import org.kop.standard.restful.resp.RestfulResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestfulExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestfulResponse r(@NotNull Exception e) {
        return RestfulResponse.err(e.getLocalizedMessage());
    }
}
