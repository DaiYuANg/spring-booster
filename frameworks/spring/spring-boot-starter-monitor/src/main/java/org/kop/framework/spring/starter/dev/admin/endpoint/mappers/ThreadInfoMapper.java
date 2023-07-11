package org.kop.framework.spring.starter.dev.admin.endpoint.mappers;

import org.kop.framework.spring.starter.dev.admin.endpoint.dto.LiveThreadDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.lang.management.ThreadInfo;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ThreadInfoMapper {

    @Mapping(target = "threadName",source = "threadName")
    @Mapping(target = "threadId",source = "threadId")
    @Mapping(target = "threadState",source = "threadState")
    @Mapping(target = "lockName",source = "lockName")
    @Mapping(target = "lockerClassName",source = "lockInfo.className")
    LiveThreadDto threadInfoConvertDto(ThreadInfo threadInfo);
}
