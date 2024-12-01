package com.gyunpang.be.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder(toBuilder = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class FaqDto {
	private Integer faqId;
	private String title;
	private String content;
	private Integer firstCommentId;
	private Integer userId;
	private Integer productId;
	private Boolean useYn;
	private LocalDateTime createTime;
	private LocalDateTime modifyTime;
	private LocalDateTime deleteTime;
	private Long version;
}
