package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.ProductDto;
import com.gyunpang.be.entity.ProductEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE,
	uses = {
		MemberMapper.class,
		CategoryMapper.class
	})
public interface ProductMapper {
	@Mapping(source = "member.memberId", target = "memberId")
	@Mapping(source = "category.categoryId", target = "categoryId")
	ProductDto.Info toInfoDto(ProductEntity entity);

	@Mapping(source = "memberId", target = "member.memberId")
	@Mapping(source = "categoryId", target = "category.categoryId")
	ProductEntity toEntity(ProductDto.Info info);

	@Mapping(source = "member.memberId", target = "memberId")
	@Mapping(source = "category.categoryId", target = "categoryId")
	@IterableMapping(elementTargetType = ProductDto.Info.class)
	List<ProductDto.Info> toInfoDtoList(List<ProductEntity> entityList);
}
