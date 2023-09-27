package org.toolkit.spring.boot.starter.minio.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.starter.minio.repositories.MinioResourceEntityRepository;

@Service
@Slf4j
public class MinioService {
	@Resource
	private MinioResourceEntityRepository resourceEntityRepository;
}
