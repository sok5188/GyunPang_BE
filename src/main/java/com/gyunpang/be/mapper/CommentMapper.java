package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.entityDto.CommentDto;
import com.gyunpang.be.entity.CommentEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE,
	uses = {
		MemberMapper.class
	})
public interface CommentMapper extends GenericMapper<CommentDto, CommentEntity> {
	CommentEntity map(Integer commentId);

	@Override
	@Mapping(source = "entity.childComment.commentId", target = "childCommentId")
	@Mapping(source = "entity.member.userId", target = "userId")
	CommentDto toDto(CommentEntity entity);

	@Override
	@Mapping(source = "childCommentId", target = "childComment")
	@Mapping(source = "userId", target = "member.userId")
	CommentEntity toEntity(CommentDto dto);

	@Override
	@Mapping(source = "childComment.commentId", target = "childCommentId")
	@Mapping(source = "member.userId", target = "userId")
	@IterableMapping(elementTargetType = CommentDto.class)
	List<CommentDto> getDtoList(List<CommentEntity> entityList);
}
