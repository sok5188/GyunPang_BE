package com.gyunpang.be.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ExceptionDto {
	String code;
	String reason;
}
