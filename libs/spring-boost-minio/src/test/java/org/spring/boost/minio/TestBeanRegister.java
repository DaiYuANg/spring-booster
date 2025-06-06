/* (C)2024*/
package org.spring.boost.minio;

import io.minio.MinioClient;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.spring.boost.core.autoconfigure.CoreAutoConfiguration;
import org.spring.boost.minio.autoconfigure.MinioAutoConfigure;
import org.spring.boost.minio.autoconfigure.MinioBeanFactoryAutoConfigure;
import org.spring.boost.minio.service.MinioTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(
  classes = {
    MinioAutoConfigure.class,
    MinioBeanFactoryAutoConfigure.class,
    TestHookConfiguration.class,
    CoreAutoConfiguration.class
  })
@RunWith(SpringRunner.class)
@TestPropertySource("classpath:application.yaml")
public class TestBeanRegister {
  @Resource
  private MinioClient client;

  @Resource
  private MinioTemplate minioTemplate;

  @Test
  void testBeanInjection() {
    Assertions.assertNotNull(client);
  }

  @Test
  void testTemplateInjection() {
    Assertions.assertNotNull(minioTemplate);
  }
}
