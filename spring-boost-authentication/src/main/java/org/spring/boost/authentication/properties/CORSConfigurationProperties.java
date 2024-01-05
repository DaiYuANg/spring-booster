package org.spring.boost.authentication.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "spring.boost.authentication.cors")
@Getter
@Setter
@ToString
public class CORSConfigurationProperties {

    private boolean enable;

    private List<String> allowedOrigins;

    private List<String> allowedMethods;
}
