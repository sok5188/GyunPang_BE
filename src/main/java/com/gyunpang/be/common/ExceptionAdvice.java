package com.gyunpang.be.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gyunpang.be.dto.ExceptionDto;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionAdvice {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<ExceptionDto> exceptionHandler(HttpServletRequest request, CustomException e) {
		return ResponseEntity.status(e.getCommonCode().getRawCode())
			.body(ExceptionDto.builder()
				.code(e.getCommonCode().getCode())
				.reason(e.getCommonCode().getDescription())
				.build()
			);
	}
}
