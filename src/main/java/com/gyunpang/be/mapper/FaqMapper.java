package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.FaqDto;
import com.gyunpang.be.entity.FaqEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE,
	uses = {
		CommentMapper.class,
		MemberMapper.class,
		ProductMapper.class
	})
public interface FaqMapper {
	@Mapping(source = "firstComment.commentId", target = "firstCommentId")
	@Mapping(source = "member.memberId", target = "memberId")
	@Mapping(source = "product.productId", target = "productId")
	FaqDto.Info toInfoDto(FaqEntity entity);

	@Mapping(source = "firstCommentId", target = "firstComment")
	@Mapping(source = "memberId", target = "member.memberId")
	@Mapping(source = "productId", target = "product.productId")
	FaqEntity toEntity(FaqDto.Info info);

	@Mapping(source = "firstComment.commentId", target = "firstCommentId")
	@Mapping(source = "member.memberId", target = "memberId")
	@Mapping(source = "product.productId", target = "productId")
	@IterableMapping(elementTargetType = FaqDto.Info.class)
	List<FaqDto.Info> toInfoDtoList(List<FaqEntity> entityList);
}
