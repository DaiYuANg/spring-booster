package org.toolkit.spring.boot.mapping.core.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.mapping.core.service.IMappingService;

@Service
@Slf4j
public class MappingService implements IMappingService {
	@PostConstruct
	public void init() {
		log.atInfo().log("mapping service bean");
	}
}
