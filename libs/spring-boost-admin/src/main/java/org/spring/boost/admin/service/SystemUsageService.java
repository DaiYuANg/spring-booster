package org.spring.boost.admin.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;

@Service
@Slf4j
@RequiredArgsConstructor
public class SystemUsageService {
  private final SystemInfo systemInfo;

  public double cpuUsage() {
    val processor = systemInfo.getHardware().getProcessor();
//    val oldTicks = processor.getSystemCpuLoadTicks();
//    val usage = processor.getSystemCpuLoadBetweenTicks(oldTicks) * 100;
//    processor.getSystemCpuLoadTicks();
//    return usage;
    // 第一次获取 CPU tick 数组和当前时间戳
    long[] oldTicks = processor.getSystemCpuLoadTicks();
    long startTime = System.currentTimeMillis();

    // 等待一段时间，确保 CPU 状态有所变化，1秒钟是一个合理的等待时间
    try {
      Thread.sleep(1000);  // 1秒钟延迟
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // 第二次获取 CPU tick 数组和当前时间戳
    long[] newTicks = processor.getSystemCpuLoadTicks();
    long endTime = System.currentTimeMillis();

    if (endTime - startTime < 1000) {
      System.out.println("时间差过小，无法获取有效数据。");
      return 0.0;
    }

    double cpuUsage = processor.getSystemCpuLoadBetweenTicks(oldTicks) * 100;
    return cpuUsage;
  }
}
