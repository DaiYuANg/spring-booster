/* (C)2024*/
package org.spring.boost.minio.autoconfigure;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.spring.boost.minio.factory.*;
import org.spring.boost.minio.properties.MinioConfigurationProperties;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@AutoConfiguration
@Slf4j
@AutoConfigureAfter(MinioAutoConfigure.class)
public class MinioBeanFactoryAutoConfigure {
    private MinioConfigurationProperties minioConfigurationProperties;

    /**
     * Register bean factory post processor is executed before register bean done so need manual
     * binder environment to make properties
     *
     * @param environment basic environment
     * @return @see{@link MinioConfigurationProperties}
     */
    private MinioConfigurationProperties bindMinioConfigurationProperties(Environment environment) {
        if (Objects.isNull(minioConfigurationProperties)) {
            minioConfigurationProperties = Binder.get(environment)
                    .bindOrCreate(MinioConfigurationProperties.prefix, MinioConfigurationProperties.class);
            return minioConfigurationProperties;
        }
        return minioConfigurationProperties;
    }

    /**
     * Minio client bean factory
     *
     * @param environment  read configuration properties
     * @param okHttpClient custom okHttpClient
     */
    @Bean
    MinioClientBeanFactoryPostProcessor minioClientBeanFactoryPostProcessor(
            Environment environment, OkHttpClient okHttpClient) {
        return new MinioClientBeanFactoryPostProcessor(bindMinioConfigurationProperties(environment), okHttpClient);
    }

    @Bean
    MinioAdminClientBeanFactoryPostProcessor minioAdminClientBeanFactoryPostProcessor(
            Environment environment, OkHttpClient okHttpClient) {
        return new MinioAdminClientBeanFactoryPostProcessor(
                bindMinioConfigurationProperties(environment), okHttpClient);
    }

    @Bean
    PrimaryMinioClientBeanFactoryPostProcessor primaryMinioClientBeanFactoryPostProcessor(
            Environment environment, OkHttpClient okHttpClient) {
        return new PrimaryMinioClientBeanFactoryPostProcessor(
                bindMinioConfigurationProperties(environment), okHttpClient);
    }

    @Bean
    PrimaryMinioAdminBeanFactoryPostProcessor primaryMinioAdminBeanFactoryPostProcessor(
            Environment environment, OkHttpClient okHttpClient) {
        return new PrimaryMinioAdminBeanFactoryPostProcessor(
                bindMinioConfigurationProperties(environment), okHttpClient);
    }

    //    @Bean
    //    @DependsOn({"primaryMinioClientBeanFactoryPostProcessor", "primaryMinioAdminBeanFactoryPostProcessor"})
    //    PrimaryTemplateBeanFactoryPostProcessor primaryTemplateBeanFactoryPostProcessor(
    //            @Name("TikaForMinio") Tika tika, Environment environment, Set<MinioHook> hooks, OkHttpClient
    // okHttpClient) {
    //        return PrimaryTemplateBeanFactoryPostProcessor.builder()
    //                .properties(bindMinioConfigurationProperties(environment))
    //                .tika(tika)
    //                .httpClient(okHttpClient)
    //                .hooks(hooks)
    //                .build();
    //    }
    //
    //    @Bean
    //    @DependsOn({"minioClientBeanFactoryPostProcessor", "minioAdminClientBeanFactoryPostProcessor"})
    //    MinioTemplateBeanFactoryPostProcessor minioTemplateBeanFactoryPostProcessor(
    //            @Name("TikaForMinio") Tika tika, Environment environment, Set<MinioHook> hooks, OkHttpClient
    // okHttpClient) {
    //        return MinioTemplateBeanFactoryPostProcessor.builder()
    //                .properties(bindMinioConfigurationProperties(environment))
    //                .tika(tika)
    //                .httpClient(okHttpClient)
    //                .hooks(hooks)
    //                .build();
    //    }
}
