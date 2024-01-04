/* (C)2023*/
package org.spring.boost.web.core.global;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.web.annotation.IgnoreResponseAdvice;
import org.spring.boost.web.core.exceptions.RestfulException;
import org.spring.boost.web.core.structure.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@IgnoreResponseAdvice
public class RestfulExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> r(@NotNull Exception e) {
        log.error(e.getMessage(), e.fillInStackTrace());
        return Response.error(e.getLocalizedMessage());
    }

    @ExceptionHandler(RestfulException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<?> restfulExceptionHandler(@NotNull RestfulException restfulException) {
        log.error(restfulException.getMessage());
        return Response.error(restfulException.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<?> handleValidationExceptions(@NotNull MethodArgumentNotValidException ex) {
        return Response.error(ex.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Response<?> hissingServletRequestParameterExceptionHandler(
            @NotNull MissingServletRequestParameterException exception) {
        return Response.error(exception.getParameterName());
    }
}
