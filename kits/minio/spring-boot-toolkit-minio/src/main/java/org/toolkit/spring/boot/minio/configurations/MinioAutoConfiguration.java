package org.toolkit.spring.boot.minio.configurations;

import io.minio.MinioClient;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.minio.configurations.properties.MinioClientConfigurationProperties;
import org.toolkit.spring.boot.minio.configurations.properties.MinioConfigurationProperties;

@AutoConfiguration
@EnableConfigurationProperties(MinioConfigurationProperties.class)
@Slf4j
public class MinioAutoConfiguration {

	@Resource
	private MinioConfigurationProperties minioConfigurationProperties;

	@PostConstruct
	public void init() {
		log.atDebug().log("Minio Auto Configuration Executing");
		log.atInfo().log(minioConfigurationProperties.toString());
	}

	@NotNull @Bean
	public ConcurrentMap<String, MinioClient> buildMinioClientMap() {
		return Observable.fromIterable(
						minioConfigurationProperties.getMinioClients().entrySet())
				.flatMap(clientConfigEntry -> Single.fromCallable(() -> clientConfigEntry)
						.subscribeOn(Schedulers.io())
						.map(this::buildClientEntry)
						.toObservable())
				.toMap(Map.Entry::getKey, Map.Entry::getValue)
				.map(clientConfigMap -> (ConcurrentMap<String, MinioClient>) new ConcurrentHashMap<>(clientConfigMap))
				.blockingGet();
	}

	@SneakyThrows
	private Map.@NotNull @Unmodifiable Entry<String, MinioClient> buildClientEntry(
			Map.@NotNull Entry<String, MinioClientConfigurationProperties> clientConfig) {
		val client = MinioClient.builder()
				.credentials(
						clientConfig.getValue().getAccessKey(),
						clientConfig.getValue().getSecretKey())
				.endpoint(clientConfig.getValue().getEndpoint())
				.build();
		return Map.entry(clientConfig.getKey(), client);
	}
}
