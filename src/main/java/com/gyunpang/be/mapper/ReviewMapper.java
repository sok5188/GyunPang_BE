package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.ReviewDto;
import com.gyunpang.be.entity.ReviewEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE,
	uses = {
		MemberMapper.class,
		ProductMapper.class
	})
public interface ReviewMapper {
	@Mapping(source = "member.memberId", target = "memberId")
	@Mapping(source = "product.productId", target = "productId")
	ReviewDto.Info toInfoDto(ReviewEntity entity);

	@Mapping(source = "memberId", target = "member.memberId")
	@Mapping(source = "productId", target = "product.productId")
	ReviewEntity toEntity(ReviewDto.Info info);

	@Mapping(source = "member.memberId", target = "memberId")
	@Mapping(source = "product.productId", target = "productId")
	@IterableMapping(elementTargetType = ReviewDto.Info.class)
	List<ReviewDto.Info> toInfoDtoList(List<ReviewEntity> entityList);
}
