package org.toolkit4j.framework.spring.starter.monitor.annotations;

import org.springframework.context.annotation.Import;
import org.toolkit4j.framework.spring.starter.monitor.configurations.DevAdminAutoConfiguration;
import org.toolkit4j.framework.spring.starter.monitor.configurations.endpoint.DevUIAutoConfiguration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DevAdminAutoConfiguration.class, DevUIAutoConfiguration.class})
public @interface EnableDevAdmin {
}
