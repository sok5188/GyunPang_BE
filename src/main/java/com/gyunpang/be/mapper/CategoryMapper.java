package com.gyunpang.be.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.entityDto.CategoryDto;
import com.gyunpang.be.entity.CategoryEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper extends GenericMapper<CategoryDto, CategoryEntity> {
	CategoryEntity map(Integer categoryId);
}
