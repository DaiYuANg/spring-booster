/* (C)2023*/
package org.toolkit.spring.boot.mapping.core.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IMappingService implements org.toolkit.spring.boot.mapping.core.service.IMappingService {
	@PostConstruct
	public void init() {
		log.atInfo().log("mapping service bean");
	}
}
