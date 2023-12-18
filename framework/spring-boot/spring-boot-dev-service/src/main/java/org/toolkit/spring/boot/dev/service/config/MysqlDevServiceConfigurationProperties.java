/* (C)2023*/
package org.toolkit.spring.boot.dev.service.config;

import static org.toolkit.spring.boot.dev.service.config.MysqlDevServiceConfigurationProperties.CONFIGURATION_NAME;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;

@Getter
@Setter
@ToString
@ConfigurationProperties(CONFIGURATION_NAME)
public class MysqlDevServiceConfigurationProperties extends DevServiceCommonConfigurationProperties {

	public static final String CONFIGURATION_NAME = "spring.dev.service.mysql";

	private String mysqlRootPassword;

	private String mysqlDatabase;

	private String mysqlUser;

	private String mysqlPassword;

	private String mysqlAllowEmptyPassword;

	private String mysqlRandomRootPassword;

	private String mysqlOnetimePassword;

	private String mysqlInitDBSkipTzInfo;

	public static MysqlDevServiceConfigurationProperties get(@NotNull Binder binder) {
		return binder.bind(CONFIGURATION_NAME, MysqlDevServiceConfigurationProperties.class)
				.orElseGet(MysqlDevServiceConfigurationProperties::new);
	}
}
