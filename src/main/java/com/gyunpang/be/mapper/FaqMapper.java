package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.entityDto.FaqDto;
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
public interface FaqMapper extends GenericMapper<FaqDto, FaqEntity> {
	FaqEntity map(Integer faqId);

	@Override
	@Mapping(source = "firstComment.commentId", target = "firstCommentId")
	@Mapping(source = "member.userId", target = "userId")
	@Mapping(source = "product.productId", target = "productId")
	FaqDto toDto(FaqEntity entity);

	@Override
	@Mapping(source = "firstCommentId", target = "firstComment")
	@Mapping(source = "userId", target = "member.userId")
	@Mapping(source = "productId", target = "product.productId")
	FaqEntity toEntity(FaqDto dto);

	@Override
	@Mapping(source = "firstComment.commentId", target = "firstCommentId")
	@Mapping(source = "member.userId", target = "userId")
	@Mapping(source = "product.productId", target = "productId")
	@IterableMapping(elementTargetType = FaqDto.class)
	List<FaqDto> getDtoList(List<FaqEntity> entityList);
}
