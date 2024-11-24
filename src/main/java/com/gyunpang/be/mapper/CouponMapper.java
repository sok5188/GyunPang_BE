package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.CouponDto;
import com.gyunpang.be.entity.CouponEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CouponMapper {

	CouponDto.Info toInfoDto(CouponEntity entity);

	CouponEntity toEntity(CouponDto.Info info);

	@IterableMapping(elementTargetType = CouponDto.Info.class)
	List<CouponDto.Info> toInfoDtoList(List<CouponEntity> entityList);
}
