package org.spring.boost.core.model;

import io.soabase.recordbuilder.core.RecordBuilder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.constant.CodeConstant;

import java.io.Serializable;

@RecordBuilder
@SuppressWarnings("unused")
public record Result<T>(
  String message,
  String code,
  T data
) implements Serializable {

  public static <T> Result<T> result(String code, String message, T data) {
    return ResultBuilder.<T>builder()
      .code(code)
      .message(message)
      .data(data)
      .build();
  }

  @Contract("_ -> new")
  public static <T> @NotNull Result<T> ok(T data) {
    return ResultBuilder.<T>builder()
      .message("success")
      .code(CodeConstant.OK)
      .data(data)
      .build();
  }

  @Contract(" -> new")
  public static <T> @NotNull Result<T> ok() {
    return ResultBuilder.<T>builder()
      .message("success")
      .code(CodeConstant.OK)
      .build();
  }

  @Contract("_, _ -> new")
  public static <T> @NotNull Result<T> fail(String message, String code) {
    return ResultBuilder.<T>builder()
      .code(code)
      .message(message)
      .build();
  }

  @Contract("_ -> new")
  public static <T> @NotNull Result<T> fail(String message) {
    return ResultBuilder.<T>builder()
      .message(message)
      .code(CodeConstant.ERROR)
      .build();
  }
}
