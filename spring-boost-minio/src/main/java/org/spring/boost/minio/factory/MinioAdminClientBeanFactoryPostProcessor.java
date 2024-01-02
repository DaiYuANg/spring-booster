/* (C)2024*/
package org.spring.boost.minio.factory;

import io.minio.admin.MinioAdminClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.minio.BeanNaming;
import org.spring.boost.minio.properties.MinioConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

@RequiredArgsConstructor
@Slf4j
public class MinioAdminClientBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	private final MinioConfigurationProperties minioConfigurationProperties;

	@Override
	public void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
		minioConfigurationProperties.getClients().forEach((key, value) -> {
			val client = MinioAdminClient.builder()
					.endpoint(value.getEndpoint())
					.credentials(value.getAccessKey(), value.getSecretKey())
					.build();
			val adminBeanKey = key + BeanNaming.ADMIN.getNaming();
			log.atTrace().log("Register Minio Admin Client:{}:{}", adminBeanKey, client);
			beanFactory.registerSingleton(adminBeanKey, client);
		});
	}
}
