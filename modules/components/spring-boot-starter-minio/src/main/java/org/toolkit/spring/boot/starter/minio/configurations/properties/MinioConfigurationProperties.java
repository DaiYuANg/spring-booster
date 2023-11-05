package org.toolkit.spring.boot.starter.minio.configurations.properties;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.minio", ignoreInvalidFields = true)
@ToString
@Getter
@Setter
public class MinioConfigurationProperties {
    private String context = "/minio";

    private String previewPattern = "/minio/preview/**";

    private Map<String, MinioClientConfigurationProperties> minioClients;

    private String previewIdParameter = "id";

    private String instancePublicAccessUrl;
}
