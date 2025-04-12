package org.spring.boost.admin.controller;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.admin.model.InternalResponseBuilder;
import org.spring.boost.admin.service.SystemUsageService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class CPUUsageHandler implements Handler {
  private final SystemUsageService service;

  @Override
  public void handle(@NotNull Context context) throws Exception {
    context.json(InternalResponseBuilder.builder().data(service.cpuUsage()).build());
  }
}
