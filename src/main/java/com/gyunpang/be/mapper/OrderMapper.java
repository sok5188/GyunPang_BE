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
		CommentMapper.class
	})
public interface OrderMapper {

	@Mapping(source = "member.memberId", target = "memberId")
	@Mapping(source = "product.productId", target = "productId")
	@Mapping(source = "coupon.couponId", target = "couponId")
	OrderDto.Info toInfoDto(OrderEntity entity);

	@Mapping(source = "memberId", target = "member.memberId")
	@Mapping(source = "productId", target = "product.productId")
	@Mapping(source = "couponId", target = "coupon")
	OrderEntity toEntity(OrderDto.Info info);

	@Mapping(source = "member.memberId", target = "memberId")
	@Mapping(source = "product.productId", target = "productId")
	@Mapping(source = "coupon.couponId", target = "couponId")
	@IterableMapping(elementTargetType = OrderDto.Info.class)
	List<OrderDto.Info> toInfoDtoList(List<OrderEntity> entityList);
}
