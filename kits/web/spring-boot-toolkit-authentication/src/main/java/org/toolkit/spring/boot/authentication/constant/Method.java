package org.toolkit.spring.boot.authentication.constant;

import lombok.experimental.UtilityClass;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;

@UtilityClass
public class Method {
    public static final RequestMethod[] ALL_METHOD ={
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
