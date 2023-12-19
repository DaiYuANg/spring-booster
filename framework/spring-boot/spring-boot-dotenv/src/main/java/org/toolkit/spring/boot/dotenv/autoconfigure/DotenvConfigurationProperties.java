/* (C)2023*/
package org.toolkit.spring.boot.dotenv.autoconfigure;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.Binder;

@ConfigurationProperties(prefix = DotenvConfigurationProperties.CONFIGURATION_NAME)
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class DotenvConfigurationProperties {
	public static final String CONFIGURATION_NAME = "spring.dotenv";

	public static DotenvConfigurationProperties get(@NotNull Binder binder) {
		return binder.bind(CONFIGURATION_NAME, DotenvConfigurationProperties.class)
				.orElseGet(DotenvConfigurationProperties::new);
	}
}
