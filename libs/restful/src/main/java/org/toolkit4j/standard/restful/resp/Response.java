package org.toolkit4j.standard.restful.resp;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@ToString
@Accessors(chain = true)
public class Response<T> implements Serializable {

	private Integer status = jakarta.ws.rs.core.Response.Status.OK.getStatusCode();

	private BigInteger code = BigInteger.valueOf(1);

	private T data;

	private String message;

	private long timestamp = System.currentTimeMillis();

	private Response() {}

	public static <T> Response<T> response(T data, String message) {
		return new Response<T>().setData(data).setMessage(message);
	}

	@Contract(" -> new")
	public static @NotNull Response<?> ok() {
		return new Response<>();
	}

	public static <T> Response<T> ok(T data) {
		return new Response<T>().setData(data);
	}

	public static <T> Response<T> ok(T data, String message) {
		return new Response<T>().setData(data).setMessage(message);
	}

	public static Response<?> err() {
		return new Response<>().setStatus(jakarta.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
	}

	public static Response<?> err(String message) {
		return new Response<>()
				.setMessage(message)
				.setStatus(jakarta.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
	}

	public static Response<?> unAuth() {
		return new Response<>().setStatus(jakarta.ws.rs.core.Response.Status.UNAUTHORIZED.getStatusCode());
	}
}
