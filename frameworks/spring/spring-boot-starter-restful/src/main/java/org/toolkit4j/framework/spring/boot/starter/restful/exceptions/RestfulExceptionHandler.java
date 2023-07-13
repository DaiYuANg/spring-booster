package org.toolkit4j.framework.spring.boot.starter.restful.exceptions;

import org.jetbrains.annotations.NotNull;
import org.toolkit4j.standard.restful.resp.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestfulExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response r(@NotNull Exception e) {
        return Response.err(e.getLocalizedMessage());
    }
}
