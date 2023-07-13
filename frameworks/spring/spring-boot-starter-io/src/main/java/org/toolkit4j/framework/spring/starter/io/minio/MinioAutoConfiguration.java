package org.toolkit4j.framework.spring.starter.io.minio;

import io.minio.MinioClient;
import jakarta.annotation.Resource;
import okhttp3.OkHttpClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.toolkit4j.libs.io.files.HttpClient;

import java.util.Objects;

@AutoConfiguration
@EnableConfigurationProperties(MinioConfigurationProperties.class)
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)
public class MinioAutoConfiguration {
    @Resource
    private MinioConfigurationProperties minioConfigurationProperties;


    @Bean
    @ConditionalOnMissingBean
    public HttpClient httpClient() {
        return new HttpClient(new OkHttpClient.Builder());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass(MinioClient.class)
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(Objects.requireNonNull(minioConfigurationProperties.getUrl(), "Minio url not configure"))
                .build();
    }
}
