package org.kop.framework.spring.boot.starter.dict.configuration;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ToString
@ConfigurationProperties(prefix = "groundwork.dict")
public class DictConfigurationProperties {
    private String dictPreSuffix = "Dict";
}
