package com.gyunpang.be.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.CouponDto;
import com.gyunpang.be.entity.CouponEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CouponMapper extends GenericMapper<CouponDto, CouponEntity> {
	CouponEntity map(Integer couponId);
}
