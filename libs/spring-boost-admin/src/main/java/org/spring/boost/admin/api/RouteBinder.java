package org.spring.boost.admin.api;

import io.javalin.Javalin;

public interface RouteBinder {
  void binding(Javalin javalin);
}
