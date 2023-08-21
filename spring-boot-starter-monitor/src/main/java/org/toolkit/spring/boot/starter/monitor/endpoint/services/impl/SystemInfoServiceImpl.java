package org.toolkit.spring.boot.starter.monitor.endpoint.services.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.starter.monitor.endpoint.dto.LiveMemoryDto;
import org.toolkit.spring.boot.starter.monitor.endpoint.dto.LiveThreadDto;
import org.toolkit.spring.boot.starter.monitor.endpoint.mappers.ThreadInfoMapper;
import org.toolkit.spring.boot.starter.monitor.endpoint.services.ISystemInfoService;
import oshi.SystemInfo;

import java.lang.management.ManagementFactory;
import java.util.Arrays;
import java.util.List;

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
		val memoryMXBean = ManagementFactory.getMemoryMXBean();
		return new LiveMemoryDto(memoryMXBean.getHeapMemoryUsage(), memoryMXBean.getNonHeapMemoryUsage());
	}

	@Override
	public SystemInfo querySystemInfo(){
        return new SystemInfo();
	}
}
