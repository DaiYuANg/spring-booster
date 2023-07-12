package org.toolkit4j.framework.spring.starter.io.minio;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "io.minio", ignoreInvalidFields = true)
@Data
@ToString
public class MinioConfigurationProperties {
    private String url;
}
