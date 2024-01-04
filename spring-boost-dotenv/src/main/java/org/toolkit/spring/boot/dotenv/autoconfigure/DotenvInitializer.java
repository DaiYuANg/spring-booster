/* (C)2023*/
package org.toolkit.spring.boot.dotenv.autoconfigure;

import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.MapPropertySource;

@Slf4j
public class DotenvInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(@NotNull ConfigurableApplicationContext applicationContext) {
        val env = applicationContext.getEnvironment();
        val dotenv = Dotenv.configure().ignoreIfMissing().load();
        Map<String, Object> propertyMap = dotenv.entries().stream()
                .collect(Collectors.toConcurrentMap(
                        entry -> entry.getKey().replace('_', '.').toLowerCase(),
                        DotenvEntry::getValue,
                        (existing, replacement) -> replacement // 覆盖重复的键
                        ));
        if (propertyMap.entrySet().stream().anyMatch(entry -> !env.containsProperty(entry.getKey()))) {
            env.getPropertySources().addLast(new MapPropertySource("dotenv", propertyMap));
        }
    }
}
