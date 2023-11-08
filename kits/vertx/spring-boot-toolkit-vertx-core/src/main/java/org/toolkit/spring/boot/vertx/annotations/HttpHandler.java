package org.toolkit.spring.boot.vertx.annotations;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface HttpHandler {
    RequestMethod method();

    String path();
}
