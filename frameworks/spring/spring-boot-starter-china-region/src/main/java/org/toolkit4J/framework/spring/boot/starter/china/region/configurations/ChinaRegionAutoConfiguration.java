package org.toolkit4J.framework.spring.boot.starter.china.region.configurations;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.toolkit4J.framework.spring.boot.starter.china.region.functional.AreasFunctional;
import org.toolkit4J.framework.spring.boot.starter.china.region.functional.CitiesFunctional;
import org.toolkit4J.framework.spring.boot.starter.china.region.functional.ProvincesFunctional;

@AutoConfiguration
@EnableConfigurationProperties(ChinaRegionConfigurationProperties.class)
@Slf4j
public class ChinaRegionAutoConfiguration {
    @Bean
    @ConditionalOnProperty(prefix = "china.region", name = "enableProvinces", havingValue = "true")
    public ProvincesFunctional provincesFunctional() {
        return new ProvincesFunctional();
    }

    @Bean
    public AreasFunctional areasFunctional() {
        return new AreasFunctional();
    }

    @Bean
    public CitiesFunctional citiesFunctional() {
        return new CitiesFunctional();
    }

    @Bean
    @ConditionalOnMissingBean(Gson.class)
    public Gson gson() {
        return new Gson();
    }
}
