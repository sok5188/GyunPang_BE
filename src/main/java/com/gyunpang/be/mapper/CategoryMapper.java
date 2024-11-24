package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.CategoryDto;
import com.gyunpang.be.entity.CategoryEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

	CategoryDto.Info toInfoDto(CategoryEntity entity);

	CategoryEntity toEntity(CategoryDto.Info info);

	@IterableMapping(elementTargetType = CategoryDto.Info.class)
	List<CategoryDto.Info> toInfoDtoList(List<CategoryEntity> entityList);
}
