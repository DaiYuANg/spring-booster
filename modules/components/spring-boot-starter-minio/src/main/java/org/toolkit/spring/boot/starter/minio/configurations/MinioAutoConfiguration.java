package org.toolkit.spring.boot.starter.minio.configurations;

import io.minio.MinioClient;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit.spring.boot.starter.minio.configurations.properties.MinioClientConfigurationProperties;
import org.toolkit.spring.boot.starter.minio.configurations.properties.MinioConfigurationProperties;

import java.util.Map;

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

    @NotNull
    @Bean
    public Map<String, MinioClient> buildMinioClientMap() {
        return Observable.fromIterable(minioConfigurationProperties.getMinioClients().entrySet())
                .flatMap(clientConfigEntry -> Observable.just(clientConfigEntry)
                        .subscribeOn(Schedulers.io())
                        .map(this::buildClientEntry)
                )
                .toMap(Map.Entry::getKey, Map.Entry::getValue)
                .blockingGet(); // 等待结果并返回
    }

    @SneakyThrows
    private Map.@NotNull @Unmodifiable Entry<String, MinioClient> buildClientEntry(Map.@NotNull Entry<String, MinioClientConfigurationProperties> clientConfig) {
//        val bucketName = clientConfig.getValue().getDefaultBucket();
        val client = MinioClient.builder()
                .credentials(clientConfig.getValue().getAccessKey(), clientConfig.getValue().getSecretKey())
                .endpoint(clientConfig.getValue().getEndpoint())
                .build();
//        val defaultBucketExists = client.bucketExists(BucketExistsArgs.builder()
//                .bucket(bucketName)
//                .build());
//        log.atInfo().log("client:{},default bucket:{} exists:{}", clientConfig.getKey(), bucketName, defaultBucketExists);
//        if (!defaultBucketExists) {
//            client.makeBucket(MakeBucketArgs.builder()
//                    .bucket(bucketName)
//                    .build());
//        }
        return Map.entry(clientConfig.getKey(), client);
    }
}
