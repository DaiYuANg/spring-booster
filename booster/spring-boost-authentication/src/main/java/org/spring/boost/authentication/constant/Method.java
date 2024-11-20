/* (C)2023*/
package org.spring.boost.authentication.constant;

import lombok.experimental.UtilityClass;
import org.springframework.web.bind.annotation.RequestMethod;

@UtilityClass
public class Method {
    public final RequestMethod[] ALL_METHOD = {
        RequestMethod.PATCH,
        RequestMethod.GET,
        RequestMethod.HEAD,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS,
        RequestMethod.PUT,
        RequestMethod.TRACE,
        RequestMethod.PATCH,
        RequestMethod.POST
    };
}
