package org.kop.framework.spring.boot.starter.recording.annotation;

import org.kop.framework.spring.boot.starter.recording.configuration.RecordingAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({RecordingAutoConfiguration.class})
@Documented
public @interface EnableRecording {

    String packages() default "";
}
