package org.toolkit.spring.boot.mapping.database.source.service.impl;

import jakarta.annotation.Resource;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.mapping.database.source.entity.MappingEntity;
import org.toolkit.spring.boot.mapping.database.source.repository.MappingEntityRepository;
import org.toolkit.spring.boot.mapping.database.source.service.MappingService;

@Service
@Slf4j
public class MappingServiceImpl implements MappingService {

	@Resource
	private MappingEntityRepository mappingEntityRepository;

	@Override
	public Optional<MappingEntity> search(String naming) {
		return mappingEntityRepository.findByNaming(naming);
	}
}
