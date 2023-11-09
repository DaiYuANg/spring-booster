package org.toolkit.spring.boot.minio.configurations;

import io.minio.MinioClient;
import io.reactivex.rxjava3.core.Observable;
import jakarta.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.minio.configurations.properties.MinioClientConfigurationProperties;
import org.toolkit.spring.boot.minio.configurations.properties.MinioConfigurationProperties;
import org.toolkit.spring.boot.minio.core.template.MinioTemplate;

@AutoConfiguration
public class TemplateAutoConfiguration {
	@Resource
	private ApplicationContext context;

	@Resource
	private MinioConfigurationProperties minioConfigurationProperties;

	@Bean
	public ConcurrentMap<String, MinioTemplate> templateMap() {
		return new ConcurrentHashMap<>(
				templates().toMap(Map.Entry::getKey, Map.Entry::getValue).blockingGet());
	}

	public Observable<Map.Entry<String, MinioTemplate>> templates() {
		val clientConfigs = minioConfigurationProperties.getMinioClients();
		val clients = context.getBeansOfType(MinioClient.class);
		return Observable.fromIterable(clients.entrySet())
				.flatMap(clientEntry -> Observable.just(clientEntry).map(entry -> buildTemplate(entry, clientConfigs)));
	}

	@NotNull private Map.@Unmodifiable Entry<String, MinioTemplate> buildTemplate(
			Map.@NotNull Entry<String, MinioClient> entry,
			@NotNull Map<String, MinioClientConfigurationProperties> clientConfigs) {
		val properties = clientConfigs.get(entry.getKey());
		val client = entry.getValue();
		val key = entry.getKey();
		return Map.entry(key + MinioTemplate.class.getName(), new MinioTemplate(client, properties.getDefaultBucket()));
	}
}
