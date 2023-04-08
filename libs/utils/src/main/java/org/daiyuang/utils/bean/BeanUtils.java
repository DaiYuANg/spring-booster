package org.daiyuang.utils.bean;

import jdk.jfr.Experimental;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.IOException;

@Experimental
@Slf4j
@UtilityClass
public final class BeanUtils {
    public static <T> void copy(T source, T target, String... ignoreFields) {
        try (DynamicType.Unloaded<Object> a = new ByteBuddy()
                .subclass(Object.class)
                .method(ElementMatchers.named("toString"))
                .intercept(FixedValue.value("Hello World!"))
                .make()) {
            a.load(source.getClass().getClassLoader()).getAllLoaded();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
