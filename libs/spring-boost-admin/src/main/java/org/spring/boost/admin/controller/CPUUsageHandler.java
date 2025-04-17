package org.spring.boost.admin.controller;

import io.javalin.Javalin;
import io.javalin.http.sse.SseClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.admin.api.RouteBinder;
import org.spring.boost.admin.service.SystemUsageService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@RequiredArgsConstructor
@Slf4j
public class CPUUsageHandler implements RouteBinder {
  private final SystemUsageService service;

  private final List<SseClient> clients = new CopyOnWriteArrayList<>();

  @Override
  public void binding(@NotNull Javalin javalin) {
    javalin.sse("/cpu/usage", sseClient -> {
        sseClient.keepAlive();
        clients.add(sseClient);
    });
  }
}
