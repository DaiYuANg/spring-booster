package org.toolkit.spring.boot.authentication.configuration.properties;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "toolkit.auth")
@Setter
@Getter
public class AuthenticationConfigurationProperties {
	private Set<PermitConfigProperties> permit = new HashSet<>();
}
