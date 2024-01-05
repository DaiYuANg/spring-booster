/* (C)2024*/
package org.spring.boost.minio;

import io.minio.MinioClient;
import jakarta.annotation.Resource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.spring.boost.minio.autoconfigure.MinioAutoConfigure;
import org.spring.boost.minio.properties.MinioClientConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MinIOContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(classes = {MinioAutoConfigure.class, TestHookConfiguration.class})
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.yaml")
@Testcontainers
@Slf4j
public class TestMinioCreateTemplate {

    @Container
    private final MinIOContainer container = new MinIOContainer("minio/minio:RELEASE.2023-09-04T19-57-37Z");

    @Rule
    public TemporaryFolder folderWithSingleFile = new TemporaryFolder() {
        @Override
        public void create() throws IOException {
            super.create();
            val tempFile = this.newFile("tempFile.txt");
            FileUtils.writeStringToFile(tempFile, "hello world", StandardCharsets.UTF_8);
        }
    };

    private MinioClient minioClient;

    @Resource
    private ApplicationEventPublisher eventPublisher;

    @SneakyThrows
    @BeforeEach
    public void setupClient() {
        minioClient = MinioClient.builder()
                .endpoint(container.getS3URL())
                .credentials(container.getUserName(), container.getPassword())
                .build();
        val config =
                new MinioClientConfig(container.getS3URL(), container.getUserName(), container.getPassword(), "test");
        log.atInfo().log("test containers config:{}", config);
    }

    @Test
    public void testTemplateUpload() {
    }
}
