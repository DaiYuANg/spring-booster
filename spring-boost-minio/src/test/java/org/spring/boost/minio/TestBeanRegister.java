/* (C)2024*/
package org.spring.boost.minio;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.spring.boost.minio.autoconfigure.MinioAutoConfigure;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {MinioAutoConfigure.class})
@RunWith(SpringRunner.class)
// @TestPropertySource("classpath:application-test.yaml")
public class TestBeanRegister {

	//	@Resource
	//	private MinioConfigurationProperties configurationProperties;

	@Resource
	private DefaultListableBeanFactory minioConfigurationProperties;

	@Test
	void testBeanInjection() {
		System.err.println(minioConfigurationProperties);
	}
}
