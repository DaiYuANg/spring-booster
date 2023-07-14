package org.toolkit4j.framework.spring.starter.monitor.endpoint.mappers;

import java.lang.management.ThreadInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.toolkit4j.framework.spring.starter.monitor.endpoint.dto.LiveThreadDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ThreadInfoMapper {

	@Mapping(target = "threadName", source = "threadName")
	@Mapping(target = "threadId", source = "threadId")
	@Mapping(target = "threadState", source = "threadState")
	@Mapping(target = "lockName", source = "lockName")
	@Mapping(target = "lockerClassName", source = "lockInfo.className")
	LiveThreadDto threadInfoConvertDto(ThreadInfo threadInfo);
}
