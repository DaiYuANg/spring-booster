package org.spring.boost.admin.controller;

import io.javalin.websocket.WsConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.eclipse.jetty.websocket.api.Session;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.admin.service.SystemUsageService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import oshi.SystemInfo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

@Component
@Slf4j
@RequiredArgsConstructor
public class SystemUsageWebsocket implements Consumer<WsConfig> {

  private final SystemUsageService usageService;

  private final SystemInfo systemInfo;

  private final List<Session> sessionList = new CopyOnWriteArrayList<>();

  @Override
  public void accept(@NotNull WsConfig wsConfig) {
    wsConfig.onConnect(connection -> {
      sessionList.add(connection.session);
    });

    wsConfig.onMessage(message -> {

    });
  }

  @Scheduled(fixedDelay = 1,timeUnit = TimeUnit.SECONDS)
  void scheduleCpu(){
    val processor = systemInfo.getHardware().getProcessor();
    long[] oldTicks = processor.getSystemCpuLoadTicks();
  }
}
