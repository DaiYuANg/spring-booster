package org.toolkit.spring.boot.starter.monitor.endpoint.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.starter.monitor.endpoint.dto.LiveMemoryDto;
import org.toolkit.spring.boot.starter.monitor.endpoint.dto.LiveThreadDto;
import oshi.SystemInfo;

@Service
public interface ISystemInfoService {
	List<LiveThreadDto> getAllThreadOfCurrentJVM();

	LiveMemoryDto getMemoryUsage();

    SystemInfo querySystemInfo();
}
