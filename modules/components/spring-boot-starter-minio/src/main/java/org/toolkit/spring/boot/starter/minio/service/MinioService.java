package org.toolkit.spring.boot.starter.minio.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.starter.minio.functional.IMinioTemplate;
import org.toolkit.spring.boot.starter.minio.functional.MinioTemplate;
import org.toolkit.spring.boot.starter.minio.repositories.MinioResourceEntityRepository;

import java.io.File;

@Service
@Slf4j
public class MinioService implements IMinioService {

    @Resource
    private IMinioTemplate minioTemplate;

    @Resource
    private MinioResourceEntityRepository resourceEntityRepository;

    public boolean upload(File file) {

        return true;
    }
}
