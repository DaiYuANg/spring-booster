package org.kop.framework.spring.starter.io.configuration;

import com.google.common.jimfs.Jimfs;
import lombok.Data;
import lombok.ToString;
import org.kop.libs.io.base.IO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.nio.file.FileSystem;

@ConfigurationProperties(prefix = "io.file.system", ignoreInvalidFields = true)
@Data
@ToString
public class FileSystemIOConfigurationProperties {

    private String basePath = System.getProperty("java.io.tmpdir");

    @Bean(name = "memoryFileSystem")
    @ConditionalOnMissingBean(FileSystem.class)
    public FileSystem fileSystem() {
        return Jimfs.newFileSystem();
    }

    @Bean
    public IO io() {
        return IO.builder().build();
    }
}
