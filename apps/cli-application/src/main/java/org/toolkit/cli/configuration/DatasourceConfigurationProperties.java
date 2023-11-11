package org.toolkit.cli.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.datasource")
@Setter
@Getter
@ToString
public class DatasourceConfigurationProperties {
	private String url;

	private String username;

	private String password;

	private String driverClassName;
}
