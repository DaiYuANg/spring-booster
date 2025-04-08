/* (C)2024*/
package org.spring.boost.authentication.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "spring.boost.authentication.csrf")
public class CSRFConfigurationProperties {
    private boolean enable;
}
