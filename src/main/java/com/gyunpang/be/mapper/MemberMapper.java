package com.gyunpang.be.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.MemberDto;
import com.gyunpang.be.entity.MemberEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper extends GenericMapper<MemberDto, MemberEntity> {
	MemberEntity map(Integer userId);
}
