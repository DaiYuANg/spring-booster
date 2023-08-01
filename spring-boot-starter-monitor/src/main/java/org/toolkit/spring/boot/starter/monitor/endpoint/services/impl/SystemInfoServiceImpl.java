package org.toolkit.spring.boot.starter.monitor.endpoint.services.impl;

import jakarta.annotation.Resource;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryManagerMXBean;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.starter.monitor.endpoint.dto.LiveMemoryDto;
import org.toolkit.spring.boot.starter.monitor.endpoint.dto.LiveThreadDto;
import org.toolkit.spring.boot.starter.monitor.endpoint.mappers.ThreadInfoMapper;
import org.toolkit.spring.boot.starter.monitor.endpoint.services.ISystemInfoService;

@Service
@Slf4j
public class SystemInfoServiceImpl implements ISystemInfoService {

	@Resource
	private ThreadInfoMapper threadInfoMapper;

	@Override
	public List<LiveThreadDto> getAllThreadOfCurrentJVM() {
		val mtb = ManagementFactory.getThreadMXBean();

		return Arrays.stream(mtb.getAllThreadIds())
				.mapToObj(mtb::getThreadInfo)
				.map(threadInfoMapper::threadInfoConvertDto)
				.toList();
	}

	@Override
	public LiveMemoryDto getMemoryUsage() {
		Runtime run = Runtime.getRuntime();
		long max = run.maxMemory();
		long total = run.totalMemory();
		long free = run.freeMemory();
		long usable = max - total + free;
		System.out.println("最大内存 = " + max);
		System.out.println("已分配内存 = " + total);
		System.out.println("已分配内存中的剩余空间 = " + free);
		System.out.println("最大可用内存 = " + usable);
		System.out.println("test = " + free / total);
		val memoryMXBean = ManagementFactory.getMemoryMXBean();
		System.err.println(memoryMXBean.getHeapMemoryUsage());
		System.err.println(memoryMXBean.getNonHeapMemoryUsage());
		for (MemoryManagerMXBean memoryManagerMXBean : ManagementFactory.getMemoryManagerMXBeans()) {
			System.err.println(memoryManagerMXBean.getName());
		}
		return new LiveMemoryDto(memoryMXBean.getHeapMemoryUsage(), memoryMXBean.getNonHeapMemoryUsage());
	}
}
