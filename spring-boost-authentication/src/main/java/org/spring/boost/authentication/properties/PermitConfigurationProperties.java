/* (C)2023*/
package org.spring.boost.authentication.properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Getter
@Setter
@ToString
public class PermitConfigurationProperties {
    private String pattern;
    private Set<RequestMethod> method;
}
