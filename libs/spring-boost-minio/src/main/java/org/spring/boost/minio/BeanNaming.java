package org.spring.boost.minio;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface BeanNaming {
  String CLIENT = "client";

  String ADMIN = "admin";

  @Contract(pure = true)
  static @NotNull String buildAdminName(String key, String type) {
    return CLIENT + "-" + key + "-" + type;
  }

  @Contract(pure = true)
  static @NotNull String buildAdminName(String type) {
    return CLIENT + "-" + "-" + type;
  }
}
