package org.kop.framework.spring.boot.starter.groundwork.dict.converters;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.Date;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, imports = {Date.class})
public interface DictDtoConverter {
}
