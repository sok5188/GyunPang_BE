package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.SellDto;
import com.gyunpang.be.entity.SellEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE,
	uses = {
		MemberMapper.class,
		OrderMapper.class
	})
public interface SellMapper extends GenericMapper<SellDto, SellEntity> {
	SellEntity map(Integer sellId);

	@Override
	@Mapping(source = "member.userId", target = "userId")
	@Mapping(source = "order.orderId", target = "orderId")
	SellDto toDto(SellEntity entity);

	@Override
	@Mapping(source = "userId", target = "member.userId")
	@Mapping(source = "orderId", target = "order.orderId")
	SellEntity toEntity(SellDto dto);

	@Override
	@Mapping(source = "member.userId", target = "userId")
	@Mapping(source = "order.orderId", target = "orderId")
	@IterableMapping(elementTargetType = SellDto.class)
	List<SellDto> getDtoList(List<SellEntity> entityList);
}
