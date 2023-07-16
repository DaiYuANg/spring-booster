package org.toolkit4J.framework.spring.boot.starter.china.region.regions;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.toolkit4J.framework.spring.boot.starter.china.region.base.AbstractRegionFunctional;
import org.toolkit4J.framework.spring.boot.starter.china.region.pojo.City;

@Slf4j
public class CitiesFunctional extends AbstractRegionFunctional<City> {
    @Value("classpath:cities.json")
    private Resource cities;


    @PostConstruct
    public void init(){
        log.info("Cities initialized");
    }

    @Override
    protected Resource parseFrom() {
        return cities;
    }

}
