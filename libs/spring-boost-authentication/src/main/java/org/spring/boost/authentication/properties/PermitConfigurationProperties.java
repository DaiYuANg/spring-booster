/* (C)2023*/
package org.spring.boost.authentication.properties;

import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.RequestMethod;

@Getter
@Setter
@ToString
public class PermitConfigurationProperties {
    private String pattern;
    private Set<RequestMethod> method;
}
