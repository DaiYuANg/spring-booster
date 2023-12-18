/* (C)2023*/
package org.toolkit.spring.boot.minio.configurations.properties;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.minio", ignoreInvalidFields = true)
@ToString
@Getter
@Setter
public class MinioConfigurationProperties {
	private String context = "/minio";

	private String previewPattern = "/minio/preview/**";

	private Map<String, MinioClientConfigurationProperties> minioClients = new HashMap<>();

	private String previewIdParameter = "id";

	private String instancePublicAccessUrl;

	private String clientTracePath;
}
