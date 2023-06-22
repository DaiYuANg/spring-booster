package org.kop.framework.spring.boot.starter.i18n;

import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceProperties;
import org.springframework.context.annotation.Bean;

import java.nio.charset.StandardCharsets;

@AutoConfiguration
public class I18nAutoConfiguration {
    @Bean
    public MessageSourceProperties messageSource() {
        val properties = new MessageSourceProperties();
        properties.setEncoding(StandardCharsets.UTF_8);
        properties.setFallbackToSystemLocale(true);
        return properties;
    }
}
