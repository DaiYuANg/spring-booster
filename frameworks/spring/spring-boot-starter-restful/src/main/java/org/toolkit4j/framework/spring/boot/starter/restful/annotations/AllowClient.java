package org.toolkit4j.framework.spring.boot.starter.restful.annotations;

import org.toolkit4j.framework.spring.boot.starter.restful.constant.ClientDevice;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AllowClient {
    ClientDevice device() default ClientDevice.ALL;
}
