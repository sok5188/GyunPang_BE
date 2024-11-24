package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.MemberDto;
import com.gyunpang.be.entity.MemberEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
	MemberDto.Info toInfoDto(MemberEntity entity);

	MemberEntity toEntity(MemberDto.Info info);

	@IterableMapping(elementTargetType = MemberDto.Info.class)
	List<MemberDto.Info> toInfoDtoList(List<MemberEntity> entityList);
}
