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
public interface SellMapper {
	@Mapping(source = "member.memberId", target = "memberId")
	@Mapping(source = "order.orderId", target = "orderId")
	SellDto.Info toInfoDto(SellEntity entity);

	@Mapping(source = "firstCommentId", target = "firstComment")
	@Mapping(source = "orderId", target = "order.orderId")
	SellEntity toEntity(SellDto.Info info);

	@Mapping(source = "member.memberId", target = "memberId")
	@Mapping(source = "order.orderId", target = "orderId")
	@IterableMapping(elementTargetType = SellDto.Info.class)
	List<SellDto.Info> toInfoDtoList(List<SellEntity> entityList);
}
