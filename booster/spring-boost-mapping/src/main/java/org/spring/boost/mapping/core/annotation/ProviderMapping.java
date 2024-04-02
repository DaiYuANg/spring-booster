package org.spring.boost.mapping.core.annotation;

import org.spring.boost.mapping.core.api.MappingProvider;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
public @interface ProviderMapping {

  Class<? extends MappingProvider> value();

  MappingConfig config();
}
