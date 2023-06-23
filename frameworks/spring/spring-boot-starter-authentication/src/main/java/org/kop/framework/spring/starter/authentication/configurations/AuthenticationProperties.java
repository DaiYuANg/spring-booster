package org.kop.framework.spring.starter.authentication.configurations;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "authentication")
@Data
@ToString
public class AuthenticationProperties {
    private boolean enableGroup;

    private boolean enablePermission;

    private boolean enableMultiDevice;

    private boolean enableAutoRefreshToken;

    private boolean autoNotification;
}
