package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.StockDto;
import com.gyunpang.be.entity.StockEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE,
	uses = {
		ProductMapper.class
	})
public interface StockMapper extends GenericMapper<StockDto, StockEntity> {
	StockEntity map(Integer stockId);

	@Override
	@Mapping(source = "product.productId", target = "productId")
	StockDto toDto(StockEntity entity);

	@Override
	@Mapping(source = "productId", target = "product.productId")
	StockEntity toEntity(StockDto dto);

	@Override
	@Mapping(source = "product.productId", target = "productId")
	@IterableMapping(elementTargetType = StockDto.class)
	List<StockDto> getDtoList(List<StockEntity> entityList);
}
