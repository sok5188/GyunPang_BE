package com.gyunpang.be.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.LogDto;
import com.gyunpang.be.entity.LogEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface LogMapper extends GenericMapper<LogDto, LogEntity> {
	LogEntity map(Integer logId);
}
