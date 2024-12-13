package org.spring.boost.persistence.annotation;

import org.hibernate.annotations.IdGeneratorType;
import org.spring.boost.persistence.generator.HibernateSnowflakeIdGenerator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@IdGeneratorType( HibernateSnowflakeIdGenerator.class )
@Target({METHOD, FIELD})
@Retention(RUNTIME)
public @interface SnowflakeGenerator {
}
