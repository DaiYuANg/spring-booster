package org.kop.framework.spring.boot.starter.groundwork.tag.configuration;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ToString
@ConfigurationProperties(prefix = "groundwork.tag")
public class TagConfigurationProperties {
    private String dictPreSuffix = "Dict";
}
