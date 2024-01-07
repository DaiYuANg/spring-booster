package org.spring.boost.web.core.feature;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.spring.boost.core.api.BeanRegistry;
import org.spring.boost.core.api.FeatureInstaller;
import org.spring.boost.web.core.annotation.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.Arrays;

@RequiredArgsConstructor
@Slf4j
public class InterceptorsFeatureInstaller implements FeatureInstaller<InterceptorRegistry> {

    private final BeanRegistry beanRegistry;

    @Override
    public void install(InterceptorRegistry interceptorRegistry) {
        beanRegistry
                .getBeanWithAnnotationMap(Interceptor.class, HandlerInterceptor.class)
                .forEach((a, i) -> {
                    val path = Arrays.stream(a.value()).toList();
                    val order = a.order();
                    val exclude = Arrays.stream(a.excludePath()).toList();
                    interceptorRegistry.addInterceptor(i)
                            .order(order)
                            .addPathPatterns(path)
                            .excludePathPatterns(exclude);
                });
    }
}
