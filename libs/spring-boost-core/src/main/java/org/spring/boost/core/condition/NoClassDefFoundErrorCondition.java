/* (C)2023*/
package org.spring.boost.core.condition;

import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class NoClassDefFoundErrorCondition implements Condition {

    @Override
    public boolean matches(@NotNull ConditionContext context, @NotNull AnnotatedTypeMetadata metadata) {
        try {
            // 尝试加载可能引发 NoClassDefFoundError 的类
            Objects.requireNonNull(context.getClassLoader()).loadClass("YourClassToCheck");
            return true; // 类加载成功，条件满足
        } catch (NoClassDefFoundError e) {
            return false; // 类加载失败，条件不满足
        } catch (ClassNotFoundException e) {
            return true; // ClassNotFoundException，条件满足
        }
    }
}
