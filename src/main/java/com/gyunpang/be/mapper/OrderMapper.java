package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.OrderDto;
import com.gyunpang.be.entity.OrderEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE,
	uses = {
		MemberMapper.class,
		ProductMapper.class,
		CouponMapper.class
	})
public interface OrderMapper extends GenericMapper<OrderDto, OrderEntity> {
	OrderEntity map(Integer orderId);

	@Override
	@Mapping(source = "member.userId", target = "userId")
	@Mapping(source = "product.productId", target = "productId")
	@Mapping(source = "coupon.couponId", target = "couponId")
	OrderDto toDto(OrderEntity entity);

	@Override
	@Mapping(source = "userId", target = "member.userId")
	@Mapping(source = "productId", target = "product.productId")
	@Mapping(source = "couponId", target = "coupon")
	OrderEntity toEntity(OrderDto dto);

	@Override
	@Mapping(source = "member.userId", target = "userId")
	@Mapping(source = "product.productId", target = "productId")
	@Mapping(source = "coupon.couponId", target = "couponId")
	@IterableMapping(elementTargetType = OrderDto.class)
	List<OrderDto> getDtoList(List<OrderEntity> entityList);
}
