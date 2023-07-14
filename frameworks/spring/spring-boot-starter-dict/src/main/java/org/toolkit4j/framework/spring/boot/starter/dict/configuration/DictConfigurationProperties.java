package org.toolkit4j.framework.spring.boot.starter.dict.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "groundwork.dict")
public class DictConfigurationProperties {
	private String dictPreSuffix = "Dict";

	private boolean loadDictMetadata = true;

	private boolean async = true;
}
