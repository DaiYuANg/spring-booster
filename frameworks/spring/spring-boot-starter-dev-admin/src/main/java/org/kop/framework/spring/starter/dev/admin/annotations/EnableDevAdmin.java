package org.kop.framework.spring.starter.dev.admin.annotations;

import org.kop.framework.spring.starter.dev.admin.configuration.DevAdminAutoConfiguration;
import org.kop.framework.spring.starter.dev.admin.configuration.ui.DevUIAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({DevAdminAutoConfiguration.class, DevUIAutoConfiguration.class})
public @interface EnableDevAdmin {
}
