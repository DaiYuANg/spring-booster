/* (C)2023*/
package org.spring.boost.mapping.database.source.service.impl;

import jakarta.annotation.Resource;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.mapping.database.source.repository.MappingEntityRepository;
import org.springframework.stereotype.Service;
import org.spring.boost.mapping.database.source.entity.MappingEntity;
import org.spring.boost.mapping.database.source.service.MappingService;

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
