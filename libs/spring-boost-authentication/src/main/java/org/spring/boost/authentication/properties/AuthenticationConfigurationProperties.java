/* (C)2023*/
package org.spring.boost.authentication.properties;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.boost.authentication")
@Setter
@Getter
public class AuthenticationConfigurationProperties {

    private Boolean debug = false;

    private String authenticateAt = "/**";

    private Set<PermitConfigurationProperties> permit = new HashSet<>();
}
