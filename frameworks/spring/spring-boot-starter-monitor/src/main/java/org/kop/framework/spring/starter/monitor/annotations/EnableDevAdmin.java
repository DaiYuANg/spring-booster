package org.kop.framework.spring.starter.monitor.annotations;

import org.kop.framework.spring.starter.monitor.configurations.DevAdminAutoConfiguration;
import org.kop.framework.spring.starter.monitor.configurations.endpoint.DevUIAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DevAdminAutoConfiguration.class, DevUIAutoConfiguration.class})
public @interface EnableDevAdmin {
}
