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
public interface CouponCodeMapper extends GenericMapper<CouponCodeDto, CouponCodeEntity> {
	CouponCodeEntity map(Integer couponCodeId);

	@Override
	@Mapping(source = "member.userId", target = "userId")
	CouponCodeDto toDto(CouponCodeEntity entity);

	@Override
	@Mapping(source = "userId", target = "member")
	CouponCodeEntity toEntity(CouponCodeDto info);

	@Override
	@Mapping(source = "member.userId", target = "userId")
	@IterableMapping(elementTargetType = CouponCodeDto.class)
	List<CouponCodeDto> getDtoList(List<CouponCodeEntity> entityList);
}
