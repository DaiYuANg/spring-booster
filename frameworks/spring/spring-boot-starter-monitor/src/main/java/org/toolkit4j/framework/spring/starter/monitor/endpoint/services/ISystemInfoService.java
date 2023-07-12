package org.toolkit4j.framework.spring.starter.monitor.endpoint.services;

import org.springframework.stereotype.Service;
import org.toolkit4j.framework.spring.starter.monitor.endpoint.dto.LiveMemoryDto;
import org.toolkit4j.framework.spring.starter.monitor.endpoint.dto.LiveThreadDto;

import java.util.List;

@Service
public interface ISystemInfoService {
    List<LiveThreadDto> getAllThreadOfCurrentJVM();

    LiveMemoryDto getMemoryUsage();
}
