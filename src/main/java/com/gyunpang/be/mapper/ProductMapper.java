package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.entityDto.ProductDto;
import com.gyunpang.be.entity.ProductEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE,
	uses = {
		MemberMapper.class,
		CategoryMapper.class
	})
public interface ProductMapper extends GenericMapper<ProductDto, ProductEntity> {
	ProductEntity map(Integer productId);

	@Override
	@Mapping(source = "member.userId", target = "userId")
	@Mapping(source = "category.categoryId", target = "categoryId")
	ProductDto toDto(ProductEntity entity);

	@Override
	@Mapping(source = "userId", target = "member.userId")
	@Mapping(source = "categoryId", target = "category.categoryId")
	ProductEntity toEntity(ProductDto dto);

	@Override
	@Mapping(source = "member.userId", target = "userId")
	@Mapping(source = "category.categoryId", target = "categoryId")
	@IterableMapping(elementTargetType = ProductDto.class)
	List<ProductDto> getDtoList(List<ProductEntity> entityList);
}
