package org.toolkit4j.framework.spring.starter.minio;

import io.minio.MinioClient;
import jakarta.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;
import lombok.val;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.toolkit4j.libs.io.files.HttpClient;

@AutoConfiguration
@EnableConfigurationProperties(MinioConfigurationProperties.class)
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)
public class MinioAutoConfiguration implements WebMvcConfigurer {
	@Resource
	private MinioConfigurationProperties minioConfigurationProperties;

	@Resource
	private ThreadPoolExecutor taskExecutor;

	@Bean
	@ConditionalOnMissingBean
	public HttpClient httpClient() {
		return new HttpClient(new OkHttpClient.Builder());
	}

	@Bean
	@ConditionalOnMissingBean
	@ConditionalOnClass(MinioClient.class)
	public Map<String, IMinioTemplate> minioInstance() {
		return minioConfigurationProperties.minioInstances.entrySet().stream()
				.map(this::createTemplate)
				.collect(Collectors.toMap(TemplateEntry::getKey, TemplateEntry::getValue));
	}

	private @NotNull TemplateEntry createTemplate(Map.@NotNull Entry<String, MinioConfig> config) {
		val client = new MinioClient.Builder()
				.endpoint(config.getValue().getEndpoint())
				.credentials(config.getValue().getAccessKey(), config.getValue().getSecretKey())
				.build();
		val template =
				config.getValue().isAsync() ? new AsyncMinioTemplate(client, taskExecutor) : new MinioTemplate(client);
		return new TemplateEntry(config.getKey(), template);
	}

	@Bean
	public MinioResourceHandler minioResourceHandler() {
		return new MinioResourceHandler();
	}

	@Override
	public void addResourceHandlers(@NotNull ResourceHandlerRegistry registry) {
		registry.addResourceHandler(minioConfigurationProperties.getAccessPrefix())
				.addResourceLocations("/")
				.resourceChain(true)
				.addResolver((ResourceResolver) minioResourceHandler());
	}
}
