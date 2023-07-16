package org.toolkit4J.framework.spring.boot.starter.china.region.base;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@ToString
@Accessors(chain = true)
@Data
public class RegionPojo implements Serializable {
    private Integer code;

    private String name;
}
