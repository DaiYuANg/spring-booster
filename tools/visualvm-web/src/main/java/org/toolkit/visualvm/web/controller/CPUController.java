/* (C)2023*/
package org.toolkit.visualvm.web.controller;

import io.javalin.http.sse.SseClient;
import jakarta.inject.Inject;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;
import lombok.SneakyThrows;
import org.toolkit.visualvm.web.service.ICPUService;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

public class CPUController {

	@Inject
	private ICPUService cpuService;

	@Inject
	private SystemInfo systemInfo;

	private final Queue<SseClient> clients = new ConcurrentLinkedQueue<SseClient>();

	@SneakyThrows
	public void cpuLoadSse(SseClient sseClient) {
		clients.add(sseClient);
		sseClient.keepAlive();
		sseClient.onClose(() -> clients.remove(sseClient));
		CompletableFuture.runAsync(() -> {
			CentralProcessor processor = systemInfo.getHardware().getProcessor();

			// 获取上一次 CPU 时间戳
			long[] prevTicks = processor.getSystemCpuLoadTicks();
			// 循环获取 CPU 占用
			while (true) {
				// 获取当前 CPU 时间戳
				long[] ticks = processor.getSystemCpuLoadTicks();

				// 计算 CPU 占用百分比
				double cpuUsage = processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100.0;
				sseClient.sendEvent("connected", cpuUsage);
				// 输出 CPU 占用百分比
				System.out.printf("Current CPU Usage: %.2f%%\n", cpuUsage);

				// 更新上一次 CPU 时间戳
				prevTicks = ticks;

				// 等待一段时间，可以根据需求调整
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		});
	}
}
