package org.toolkit.spring.boot.starter.minio.service;

import jakarta.annotation.Resource;
import java.io.File;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.starter.minio.functional.IMinioTemplate;
import org.toolkit.spring.boot.starter.minio.helpers.FileHelper;
import org.toolkit.spring.boot.starter.minio.repositories.MinioResourceEntityRepository;

@Service
@Slf4j
public class MinioService implements IMinioService {

	@Resource
	private IMinioTemplate minioTemplate;

	@Resource
	private MinioResourceEntityRepository resourceEntityRepository;

	public boolean upload(File file) {
		val md5 = FileHelper.calculateFileMd5(file);
		return true;
	}
}
