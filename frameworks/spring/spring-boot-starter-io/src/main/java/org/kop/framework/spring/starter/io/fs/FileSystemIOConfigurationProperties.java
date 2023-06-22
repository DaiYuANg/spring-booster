package org.kop.framework.spring.starter.io.fs;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "io.file.system", ignoreInvalidFields = true)
@Data
@ToString
public class FileSystemIOConfigurationProperties {

    private String basePath = System.getProperty("java.io.tmpdir");
}
