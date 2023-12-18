/* (C)2023*/
package org.toolkit.spring.boot.minio.configurations;

import io.minio.MinioClient;
import jakarta.annotation.Resource;
import java.util.Map;
import lombok.val;
import org.apache.tika.Tika;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.toolkit.minio.MinioTemplate;
import org.toolkit.spring.boot.minio.configurations.properties.MinioConfigurationProperties;

@AutoConfiguration
public class TemplateAutoConfiguration {
	@Resource
	private ApplicationContext context;

	@Resource
	private MinioConfigurationProperties minioConfigurationProperties;

	@Resource
	private Tika tika;

	//	@Bean
	//	public ConcurrentMap<String, MinioTemplate> templateMap() {
	//		return new ConcurrentHashMap<>(
	//				templates().toMap(Map.Entry::getKey, Map.Entry::getValue).blockingGet());
	//	}
	//
	//	public Observable<Map.Entry<String, MinioTemplate>> templates() {
	//		val clientConfigs = minioConfigurationProperties.getMinioClients();
	//		val clients = context.getBeansOfType(MinioClient.class);
	//		return Observable.fromIterable(clients.entrySet())
	//				.flatMap(clientEntry -> Observable.just(clientEntry).map(this::buildTemplate));
	//	}

	@NotNull private Map.@Unmodifiable Entry<String, MinioTemplate> buildTemplate(
			Map.@NotNull Entry<String, MinioClient> entry) {
		val client = entry.getValue();
		val key = entry.getKey();
		val template = MinioTemplate.builder()
				.client(client)
				.defaultBucket(key)
				.tika(tika)
				.build();
		return Map.entry(key + MinioTemplate.class.getName(), template);
	}
}
