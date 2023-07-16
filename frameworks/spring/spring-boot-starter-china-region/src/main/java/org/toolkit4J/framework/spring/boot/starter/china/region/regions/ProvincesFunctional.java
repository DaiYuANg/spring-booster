package org.toolkit4J.framework.spring.boot.starter.china.region.regions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.toolkit4J.framework.spring.boot.starter.china.region.base.AbstractRegionFunctional;
import org.toolkit4J.framework.spring.boot.starter.china.region.pojo.City;
import org.toolkit4J.framework.spring.boot.starter.china.region.pojo.Province;

import java.util.Set;

@Slf4j
public class ProvincesFunctional extends AbstractRegionFunctional<Province> {

    @jakarta.annotation.Resource
    private CitiesFunctional citiesFunctional;

    @Value("classpath:provinces.json")
    private Resource provinces;

    @Override
    protected Resource parseFrom() {
        return provinces;
    }

    public Set<City> getSubordinate(Integer code) {
        return citiesFunctional.searchAll(city -> city.getProvinceCode().equals(code));
    }
}
