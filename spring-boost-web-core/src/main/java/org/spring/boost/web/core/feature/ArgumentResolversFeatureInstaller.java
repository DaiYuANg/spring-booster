package org.spring.boost.web.core.feature;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.core.api.FeatureInstaller;
import org.spring.boost.web.core.resolver.UserAgentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class ArgumentResolversFeatureInstaller implements FeatureInstaller<List<HandlerMethodArgumentResolver>> {

    private final UserAgentResolver userAgentResolver;

    @Override
    public void install(@NotNull List<HandlerMethodArgumentResolver> handlerMethodArgumentResolvers) {
        handlerMethodArgumentResolvers.add(userAgentResolver);
    }
}
