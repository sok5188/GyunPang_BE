package com.gyunpang.be;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.gyunpang.be.dto.CommentDto;
import com.gyunpang.be.dto.MemberDto;
import com.gyunpang.be.entity.CommentEntity;
import com.gyunpang.be.entity.MemberEntity;
import com.gyunpang.be.mapper.CommentMapper;
import com.gyunpang.be.mapper.MemberMapper;

@SpringBootTest
@ActiveProfiles("local")
public class MapperTest {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	CommentMapper commentMapper;

	@Test
	void memberMapper() {
		MemberDto info = MemberDto.builder().name("sirong").build();
		MemberEntity entity = memberMapper.toEntity(info);
		assertEquals(info.getName(), entity.getName());
	}

	@Test
	void CommentMapper() {
		CommentDto dto = CommentDto.builder().childCommentId(2).content("abc").userId(1).build();
		CommentEntity entity = commentMapper.toEntity(dto);
		assertEquals(dto.getContent(), entity.getContent());
		assertEquals(dto.getUserId(), entity.getMember().getUserId());
		assertEquals(dto.getChildCommentId(), entity.getChildComment().getCommentId());

	}
}
