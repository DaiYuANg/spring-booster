package org.kop.framework.spring.boot.starter.dict.converters;

import org.kop.framework.spring.boot.starter.dict.funcational.DictItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.Date;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {Date.class})
public interface DictDtoConverter {

    @Mapping(target = "code", ignore = true)
    @Mapping(target = "text", ignore = true)
    @Mapping(target = "name", ignore = true)
    DictItem entityToPojo(DictItem dict);
}
