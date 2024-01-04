/* (C)2023*/
package org.spring.boost.authentication.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "toolkit.auth.jwt")
public class JwtConfigProperties {

    private String secretKey;

    private long expiration = 1000 * 60 * 24;

    private long refreshTokenExpiration;

    private String encryptArithmetic;
}
