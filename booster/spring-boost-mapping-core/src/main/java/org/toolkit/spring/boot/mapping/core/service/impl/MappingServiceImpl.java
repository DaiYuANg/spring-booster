/* (C)2023*/
package org.toolkit.spring.boot.mapping.core.service.impl;

import it.unimi.dsi.fastutil.objects.Object2ObjectArrayMap;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.mapping.core.service.MappingService;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class MappingServiceImpl implements MappingService {
  @PostConstruct
  public void init() {
    log.atInfo().log("mapping service bean");
  }

  public Map<String, Object> doMapping(Object o) {
    return new Object2ObjectArrayMap<>();
  }
}
