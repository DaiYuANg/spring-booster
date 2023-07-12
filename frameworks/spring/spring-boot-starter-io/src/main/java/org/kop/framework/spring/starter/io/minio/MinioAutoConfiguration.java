package org.kop.framework.spring.starter.io.minio;

import io.minio.MinioClient;
import jakarta.annotation.Resource;
import okhttp3.OkHttpClient;
import org.kop.libs.io.files.HttpClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;

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
    public MinioClient minioClient() {
//        return MinioClient.builder()
//                .endpoint(Objects.requireNonNull(minioConfigurationProperties.getUrl(), "Minio url not configure"))
//                .httpClient(httpClient().getClient())
//                .build();
        return MinioClient.builder().build();
    }
}
