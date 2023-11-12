package org.toolkit.spring.boot.minio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.toolkit.spring.boot.minio.core.template.MinioTemplate;

@SpringBootTest
@Testcontainers
class MinioTemplateTest {

	private MinioTemplate minioTemplate;

	@Container // 标记为 Testcontainers 容器
	private static final GenericContainer<?> minioContainer = new GenericContainer<>("minio/minio")
			.withExposedPorts(9000)
			.withEnv("MINIO_ROOT_USER", "testuser")
			.withEnv("MINIO_ROOT_PASSWORD", "testpassword");

	@BeforeEach
	void setup() throws Exception {
		// 获取 MinIO 容器的 IP 和端口
		String minioIpAddress = minioContainer.getHost();
		int minioPort = minioContainer.getMappedPort(9000);

		//		minioTemplate = new MinioTemplate(MinioClient.builder()
		//				.endpoint("localhost:" + minioPort)
		//				.credentials("testuser", "testpassword")
		//				.build());
	}

	@Test
	void upload() {
		String objectName = "testobject.txt";
		String content = "Hello, Testcontainers!";
		//        minioTemplate.upload()
	}

	@Test
	void testUpload() {}

	@Test
	void testUpload1() {}

	@Test
	void testUpload2() {}
}
