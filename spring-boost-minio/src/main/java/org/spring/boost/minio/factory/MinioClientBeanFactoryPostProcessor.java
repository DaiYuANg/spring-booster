/* (C)2024*/
package org.spring.boost.minio.factory;

import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.minio.properties.MinioConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

@RequiredArgsConstructor
@Slf4j
public class MinioClientBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private final MinioConfigurationProperties minioConfigurationProperties;

	@Override
	public void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
		minioConfigurationProperties.getClients().forEach((key, value) -> {
			val client = MinioClient.builder()
					.endpoint(value.getEndpoint())
					.credentials(value.getAccessKey(), value.getSecretKey())
					.build();
			log.atTrace().log("Register Minio Client:{}:{}", key, client);
			beanFactory.registerSingleton(key, client);
		});
	}
}
