package org.toolkit.spring.boot.starter.dict.converters;

import java.util.Date;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.toolkit.spring.boot.starter.dict.funcational.DictItem;

@Mapper(
		componentModel = MappingConstants.ComponentModel.SPRING,
		imports = {Date.class})
public interface DictDtoConverter {

	@Mapping(target = "code", ignore = true)
	@Mapping(target = "text", ignore = true)
	@Mapping(target = "name", ignore = true)
	DictItem entityToPojo(DictItem dict);
}
