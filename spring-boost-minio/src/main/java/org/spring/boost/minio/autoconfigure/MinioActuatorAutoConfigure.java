/* (C)2024*/
package org.spring.boost.minio.autoconfigure;

import com.google.common.collect.ImmutableMap;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.common.api.BeanRegistry;
import org.spring.boost.minio.MinioTemplate;
import org.spring.boost.minio.actuator.MinioEndpoint;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

@AutoConfiguration
@AutoConfigureAfter(MinioBeanFactoryAutoConfigure.class)
public class MinioActuatorAutoConfigure {

	@Bean
	ImmutableMap<String, MinioTemplate> templateMap(@NotNull BeanRegistry beanRegistry) {
		return beanRegistry.getBeanOfTypeImmutable(MinioTemplate.class);
	}

	@Bean
	@DependsOn("minioTemplateBeanFactoryPostProcessor")
	MinioEndpoint minioEndpoint(ImmutableMap<String, MinioTemplate> templates) {
		return MinioEndpoint.builder().templates(templates).build();
	}
}
