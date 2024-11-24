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
public interface StockMapper {
	@Mapping(source = "product.productId", target = "productId")
	StockDto.Info toInfoDto(StockEntity entity);

	@Mapping(source = "productId", target = "product.productId")
	StockEntity toEntity(StockDto.Info info);

	@Mapping(source = "product.productId", target = "productId")
	@IterableMapping(elementTargetType = StockDto.Info.class)
	List<StockDto.Info> toInfoDtoList(List<StockEntity> entityList);
}
