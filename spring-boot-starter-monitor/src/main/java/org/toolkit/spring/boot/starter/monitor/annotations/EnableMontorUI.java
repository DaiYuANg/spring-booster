package org.toolkit.spring.boot.starter.monitor.annotations;

import java.lang.annotation.*;
import org.springframework.context.annotation.Import;
import org.toolkit.spring.boot.starter.monitor.configurations.MonitorAutoConfiguration;
import org.toolkit.spring.boot.starter.monitor.configurations.endpoint.MonitorUIAutoConfiguration;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({MonitorAutoConfiguration.class, MonitorUIAutoConfiguration.class})
public @interface EnableMontorUI {}
