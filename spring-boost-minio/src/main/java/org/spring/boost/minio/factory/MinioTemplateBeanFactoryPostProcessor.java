/* (C)2024*/
package org.spring.boost.minio.factory;

import io.minio.MinioClient;
import io.minio.admin.MinioAdminClient;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.tika.Tika;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.minio.hook.MinioHook;
import org.spring.boost.minio.properties.MinioConfigurationProperties;
import org.spring.boost.minio.template.MinioCreateTemplate;
import org.spring.boost.minio.template.MinioGetTemplate;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

@Builder
@Slf4j
public class MinioTemplateBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private final MinioConfigurationProperties properties;

	private final Tika tika;

	@Override
	public void postProcessBeanFactory(@NotNull ConfigurableListableBeanFactory beanFactory) throws BeansException {
		val hooks =
				beanFactory.getBeansOfType(MinioHook.class).values().stream().collect(Collectors.toUnmodifiableSet());
		properties.getClients().forEach((k, v) -> {
			val client = beanFactory.getBean(k, MinioClient.class);
			val adminClient = beanFactory.getBean(k + BeanNaming.ADMIN.getNaming(), MinioAdminClient.class);
			val getTemplate = MinioGetTemplate.builder()
					.adminClient(adminClient)
					.client(client)
					.bucket(v.getBucket())
					.tika(tika)
					.hooks(hooks)
					.checkDuplicate(properties.isCheckDuplicate())
					.build();
			val createTemplate = MinioCreateTemplate.builder()
					.adminClient(adminClient)
					.client(client)
					.bucket(v.getBucket())
					.tika(tika)
					.hooks(hooks)
					.checkDuplicate(properties.isCheckDuplicate())
					.build();
			val createTemplateBeanKey = k + BeanNaming.CREATE_TEMPLATE.getNaming();
			val getTemplateBeanKey = k + BeanNaming.GET_TEMPLATE.getNaming();
			log.atTrace().log("Register MinioTemplate:{}:{}", createTemplateBeanKey, createTemplate);
			beanFactory.registerSingleton(createTemplateBeanKey, createTemplate);
			beanFactory.registerSingleton(getTemplateBeanKey, getTemplateBeanKey);
		});
	}
}
