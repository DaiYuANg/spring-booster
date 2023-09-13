package org.toolkit.spring.boot.starter.minio.configurations;

import io.minio.MinioClient;
import jakarta.annotation.Resource;

import java.util.Map;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.toolkit.spring.boot.starter.minio.*;

@AutoConfiguration
@EnableConfigurationProperties(MinioConfigurationProperties.class)
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)
@Slf4j
public class MinioAutoConfiguration implements WebMvcConfigurer {

    @Resource
    private AnnotationConfigApplicationContext annotationConfigApplicationContext;

    @Resource
    private MinioConfigurationProperties minioConfigurationProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnClass(MinioClient.class)
    public Map<String, IMinioTemplate> minioInstance() {
        log.info("initialize minio clients");
        return minioConfigurationProperties.minioInstances
                .entrySet().stream()
                .map(this::createTemplate)
                .collect(Collectors.toMap(TemplateEntry::getKey, TemplateEntry::getValue));
    }

    private @NotNull TemplateEntry createTemplate(Map.@NotNull Entry<String, MinioConfig> config) {
        val client = new MinioClient.Builder()
                .endpoint(config.getValue().getEndpoint())
                .credentials(config.getValue().getAccessKey(), config.getValue().getSecretKey())
                .build();
        val template = new MinioTemplate(client);
        return new TemplateEntry(config.getKey(), template);
    }

    @Bean
    public MinioResourceHandler minioResourceHandler() {
        return new MinioResourceHandler();
    }

    @Override
    public void addResourceHandlers(@NotNull ResourceHandlerRegistry registry) {
        //		registry.addResourceHandler(minioConfigurationProperties.getAccessPrefix())
        //				.addResourceLocations("/")
        //				.resourceChain(true)
        //				.addResolver((ResourceResolver) minioResourceHandler());
    }

    public void registerBeanDynamically(@NotNull BeanDefinitionRegistry registry, String beanName, Class<?> beanClass) {
        val builder = BeanDefinitionBuilder.genericBeanDefinition(beanClass);
        registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
    }
}
