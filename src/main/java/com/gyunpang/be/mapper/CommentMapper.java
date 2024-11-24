package com.gyunpang.be.mapper;

import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.gyunpang.be.dto.CommentDto;
import com.gyunpang.be.entity.CommentEntity;

@Mapper(
	componentModel = "spring",
	unmappedSourcePolicy = ReportingPolicy.IGNORE,
	unmappedTargetPolicy = ReportingPolicy.IGNORE,
	uses = {
		MemberMapper.class
	})
public interface CommentMapper {
	@Mapping(source = "childComment.commentId", target = "childCommentId")
	@Mapping(source = "member.memberId", target = "memberId")
	CommentDto.Info toInfoDto(CommentEntity entity);

	@Mapping(source = "childCommentId", target = "childComment")
	@Mapping(source = "memberId", target = "member.memberId")
	CommentEntity toEntity(CommentDto.Info info);

	@Mapping(source = "childComment.commentId", target = "childCommentId")
	@Mapping(source = "member.memberId", target = "memberId")
	@IterableMapping(elementTargetType = CommentDto.Info.class)
	List<CommentDto.Info> toInfoDtoList(List<CommentEntity> entityList);
}
