package org.toolkit.spring.boot.starter.restful.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.toolkit.spring.boot.starter.restful.resp.Response;

@RestControllerAdvice
@Slf4j
public class RestfulExceptionHandler {
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Response<?> r(@NotNull Exception e) {
		log.error(e.fillInStackTrace().getMessage());
		return Response.error(e.getLocalizedMessage());
	}

	@ExceptionHandler(RestfulException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Response<?> response(@NotNull RestfulException restfulException) {
		log.error(restfulException.getMessage());
		return Response.error(restfulException.getMessage());
	}
}