package org.kop.framework.spring.starter.dev.admin.endpoint.services.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.kop.framework.spring.starter.dev.admin.endpoint.dto.LiveMemoryDto;
import org.kop.framework.spring.starter.dev.admin.endpoint.dto.LiveThreadDto;
import org.kop.framework.spring.starter.dev.admin.endpoint.mappers.ThreadInfoMapper;
import org.kop.framework.spring.starter.dev.admin.endpoint.services.ISystemInfoService;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
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
        var memoryMXBean = ManagementFactory.getMemoryMXBean();
        return new LiveMemoryDto(memoryMXBean.getHeapMemoryUsage(),
                                  memoryMXBean.getNonHeapMemoryUsage());
    }
}
