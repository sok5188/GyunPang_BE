package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.CouponCodeDto;
import com.gyunpang.be.entity.CouponCodeEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE,
	uses = {
		MemberMapper.class
	})
public interface CouponCodeMapper {
	@Mapping(source = "member.memberId", target = "memberId")
	CouponCodeDto.Info toInfoDto(CouponCodeEntity entity);

	@Mapping(source = "memberId", target = "member")
	CouponCodeEntity toEntity(CouponCodeDto.Info info);

	@Mapping(source = "member.memberId", target = "memberId")
	@IterableMapping(elementTargetType = CouponCodeDto.Info.class)
	List<CouponCodeDto.Info> toInfoDtoList(List<CouponCodeEntity> entityList);
}
