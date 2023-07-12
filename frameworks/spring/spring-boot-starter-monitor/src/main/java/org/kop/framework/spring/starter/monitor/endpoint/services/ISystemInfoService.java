package org.kop.framework.spring.starter.monitor.endpoint.services;

import org.kop.framework.spring.starter.monitor.endpoint.dto.LiveMemoryDto;
import org.kop.framework.spring.starter.monitor.endpoint.dto.LiveThreadDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISystemInfoService {
    List<LiveThreadDto> getAllThreadOfCurrentJVM();

    LiveMemoryDto getMemoryUsage();
}
