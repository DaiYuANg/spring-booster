package org.toolkit.spring.boot.web.core.structure;

import java.io.Serializable;
import java.math.BigInteger;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Data
@ToString
@Accessors(chain = true)
public class Response<T> implements Serializable {

	private Integer status = 200;

	private BigInteger code = BigInteger.valueOf(1);

	private T data;

	private String message;

	private String version;

	private long timestamp = System.currentTimeMillis();

	private Response() {}

	public static <T> Response<T> response(T data, String message) {
		return new Response<T>().setData(data).setMessage(message);
	}

	@Contract(" -> new")
	public static @NotNull Response<?> success() {
		return new Response<>();
	}

	public static <T> Response<T> success(T data) {
		return new Response<T>().setData(data);
	}

	public static <T> Response<T> success(T data, String message) {
		return new Response<T>().setData(data).setMessage(message);
	}

	public static Response<?> error() {
		return new Response<>().setStatus(500);
	}

	public static Response<?> error(String message) {
		return new Response<>().setMessage(message).setStatus(500);
	}

	public static Response<?> unAuth() {
		return new Response<>().setStatus(500);
	}
}
