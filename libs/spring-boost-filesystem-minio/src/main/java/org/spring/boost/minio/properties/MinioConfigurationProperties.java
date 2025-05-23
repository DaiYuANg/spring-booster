/* (C)2024*/
package org.spring.boost.minio.properties;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(MinioConfigurationProperties.prefix)
@Getter
@Setter
@ToString
public class MinioConfigurationProperties {

    public static final String prefix = "spring.boost.minio";

    private Map<String, MinioClientConfig> clients = new HashMap<>();

    private MinioClientConfig client;

    private boolean checkDuplicate = false;
}
