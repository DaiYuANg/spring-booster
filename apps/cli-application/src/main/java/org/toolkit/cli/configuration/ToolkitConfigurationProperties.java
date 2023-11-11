package org.toolkit.cli.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit")
@Setter
@Getter
@ToString
public class ToolkitConfigurationProperties {
	private String packageName;
}
