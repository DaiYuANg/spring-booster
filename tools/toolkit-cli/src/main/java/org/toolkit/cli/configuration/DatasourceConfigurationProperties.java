/* (C)2023*/
package org.toolkit.cli.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class DatasourceConfigurationProperties {
	private String url;

	private String username;

	private String password;

	private String driverClassName;
}
