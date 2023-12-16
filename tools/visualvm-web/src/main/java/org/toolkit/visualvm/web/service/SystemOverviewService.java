/* (C)2023*/
package org.toolkit.visualvm.web.service;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.toolkit.visualvm.web.dto.SystemOverviewDto;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;

@RequiredArgsConstructor(onConstructor_ = @Inject)
@Slf4j
public class SystemOverviewService implements ISystemOverviewServie {

	private final SystemInfo systemInfo;

	@Override
	public SystemOverviewDto si() {
		val builder = SystemOverviewDto.builder();
		cpuLoad();
		return builder.build();
	}

	@Override
	public void cpuLoad() {
		// 获取 CentralProcessor 对象
		CentralProcessor processor = systemInfo.getHardware().getProcessor();

		// 获取系统启动时间
		long systemUptime = systemInfo.getOperatingSystem().getSystemUptime();

		// 获取 CPU 负载
		double[] loadAverage = processor.getSystemLoadAverage(3); // 获取过去 1 分钟、5 分钟和 15 分钟的平均负载
		System.out.println("System Uptime: " + systemUptime);
		System.out.println("1 Minute Load Average: " + loadAverage[0]);
		System.out.println("5 Minutes Load Average: " + loadAverage[1]);
		System.out.println("15 Minutes Load Average: " + loadAverage[2]);
	}

	@SneakyThrows
	public static void main(String[] args) {
		SystemInfo systemInfo = new SystemInfo();
		CentralProcessor processor = systemInfo.getHardware().getProcessor();

		// 获取上一次 CPU 时间戳
		long[] prevTicks = processor.getSystemCpuLoadTicks();

		// 循环获取 CPU 占用
		while (true) {
			// 获取当前 CPU 时间戳
			long[] ticks = processor.getSystemCpuLoadTicks();

			// 计算 CPU 占用百分比
			double cpuUsage = processor.getSystemCpuLoadBetweenTicks(prevTicks) * 100.0;

			// 输出 CPU 占用百分比
			System.out.printf("Current CPU Usage: %.2f%%\n", cpuUsage);

			// 更新上一次 CPU 时间戳
			prevTicks = ticks;

			// 等待一段时间，可以根据需求调整
			Thread.sleep(1000);
		}
	}
}
