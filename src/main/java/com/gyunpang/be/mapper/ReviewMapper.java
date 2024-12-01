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
public interface ReviewMapper extends GenericMapper<ReviewDto, ReviewEntity> {
	ReviewEntity map(Integer reviewId);

	@Override
	@Mapping(source = "member.userId", target = "userId")
	@Mapping(source = "product.productId", target = "productId")
	ReviewDto toDto(ReviewEntity entity);

	@Override
	@Mapping(source = "userId", target = "member.userId")
	@Mapping(source = "productId", target = "product.productId")
	ReviewEntity toEntity(ReviewDto dto);

	@Override
	@Mapping(source = "member.userId", target = "userId")
	@Mapping(source = "product.productId", target = "productId")
	@IterableMapping(elementTargetType = ReviewDto.class)
	List<ReviewDto> getDtoList(List<ReviewEntity> entityList);
}
