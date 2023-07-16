package org.toolkit4J.framework.spring.boot.starter.china.region.regions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.toolkit4J.framework.spring.boot.starter.china.region.base.AbstractRegionFunctional;
import org.toolkit4J.framework.spring.boot.starter.china.region.pojo.Area;

@Component
@Slf4j
public class AreasFunctional extends AbstractRegionFunctional<Area> {
    @Value("classpath:areas.json")
    private Resource areas;

    @Override
    protected Resource parseFrom() {
        return areas;
    }
}
