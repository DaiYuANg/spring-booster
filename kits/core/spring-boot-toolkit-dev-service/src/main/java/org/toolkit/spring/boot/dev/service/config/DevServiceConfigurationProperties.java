package org.toolkit.spring.boot.dev.service.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;

@ConfigurationProperties(prefix = DevServiceConfigurationProperties.CONFIGURATION_NAME)
@Getter
@Setter
@ToString
public class DevServiceConfigurationProperties {
	public static final String CONFIGURATION_NAME = "spring.dev.service";

	private Boolean enable = true;

	private String dockerHost;

	private Boolean dockerTlsVerify;

	private String dockerCertPath;

	private String registryUsername;

	private String registryPassword;

	private String registryEmail;

	private String registryUrl;

	private String automaticClose;

	public static DevServiceConfigurationProperties get(@NotNull Binder binder) {
		return binder.bind(CONFIGURATION_NAME, DevServiceConfigurationProperties.class)
				.orElseGet(DevServiceConfigurationProperties::new);
	}
}
