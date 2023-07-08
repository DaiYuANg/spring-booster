package org.kop.framework.spring.starter.dev.admin.endpoint.services;

import org.kop.framework.spring.starter.dev.admin.endpoint.dto.LiveThreadDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISystemInfoService {
    List<LiveThreadDto> getAllThreadOfCurrentJVM();
}
