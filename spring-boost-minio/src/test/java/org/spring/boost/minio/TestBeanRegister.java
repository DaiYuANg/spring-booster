/* (C)2024*/
package org.spring.boost.minio;

import io.minio.MinioClient;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.spring.boost.minio.autoconfigure.MinioAutoConfigure;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {MinioAutoConfigure.class, TestHookConfiguration.class})
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.yaml")
public class TestBeanRegister {
	@Resource
	@Qualifier("client1") private MinioClient client;

	@Test
	void testBeanInjection() {
		Assertions.assertNotNull(client);
	}
}
