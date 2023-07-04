package org.kop.framework.spring.starter.io.configuration;

import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.Ordered;

@AutoConfiguration
@AutoConfigureOrder(Ordered.LOWEST_PRECEDENCE)
@EnableConfigurationProperties(FileSystemIOConfigurationProperties.class)
public class FileSystemIOAutoConfiguration {

    @Resource
    private FileSystemIOConfigurationProperties fileSystemIOConfigurationProperties;
}
