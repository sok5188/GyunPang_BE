package com.gyunpang.be.common;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
	private final CommonCode commonCode;

	public CustomException(CommonCode commonCode) {
		super(commonCode.getCode());
		this.commonCode = commonCode;
	}

	public CommonCode getCommonCode() {
		return this.commonCode;
	}
}
