package org.toolkit.spring.boot.starter.minio.configurations;

import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@Slf4j
public class MineTypeAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(Tika.class)
    public Tika tika() {
        return new Tika();
    }
}
