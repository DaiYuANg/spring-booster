/* (C)2023*/
package org.toolkit.visualvm.web.service;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import oshi.SystemInfo;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class CPUService implements ICPUService {

	private final SystemInfo systemInfo;

	@Override
	public void load() {
		val processor = systemInfo.getHardware().getProcessor();

		// 获取上一次 CPU 时间戳
		long[] prevTicks = processor.getSystemCpuLoadTicks();
	}
}
