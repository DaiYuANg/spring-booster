package org.toolkit.spring.boot.route.converter;

import org.mapstruct.*;
import org.toolkit.spring.boot.route.dto.RouteEntityDto;
import org.toolkit.spring.boot.route.entity.RouteEntity;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RouteEntityConverter {
	RouteEntity toEntity(RouteEntityDto routeEntityDto);

	RouteEntityDto toDto(RouteEntity routeEntity);

	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	RouteEntity partialUpdate(RouteEntityDto routeEntityDto, @MappingTarget RouteEntity routeEntity);
}
