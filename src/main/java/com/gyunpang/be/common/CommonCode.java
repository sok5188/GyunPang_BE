package com.gyunpang.be.common;

import lombok.Getter;

@Getter
public enum CommonCode {
	REQ_STATUS_SUCCES("RES-000", 200, "RES-SUCCESS", "Request has been successfully handled"),
	REQ_STATUS_FAIL_DUPLICATE("RES-001", 400, "RES-FAIL-DUPLICATED", "Request Duplicated"),

	AUTH_STATUS_VALID("AUTH-000", 200, "SIGNUP_VALID", "Success to Signup"),
	AUTH_STATUS_DUPLICATE_ID("AUTH-001", 400, "SIGNUP_FAIL_DUPLICATE_ID", "Username is already exist"),
	AUTH_STATUS_DUPLICATE_EMAIL("AUTH-002", 400, "SIGNUP_FAIL_DUPLICATE_EMAIL", "Email is already exist"),
	AUTH_STATUS_EXIST("AUTH-003", 400, "SIGNUP_FAIL_DUPLICATE_USER", "User already exist"),
	AUTH_STATUS_MEMBER_NOT_EXIST("AUTH-004", 400, "AUTH_FIND_FAIL_MEMBER_NOT_EXIST", "User is not exist"),
	AUTH_STATUS_EMAIL_NOT_EXIST("AUTH-005", 400, "AUTH_FIND_FAIL_EMAIL_NOT_EXIST", "email is not exist"),
	AUTH_STATUS_INVALID_PASSWORD("AUTH-006", 400, "AUTH_INVALID_PASSWORD", "Password is not correct"),

	;

	private final String code;
	private final Integer rawCode;
	private final String name;
	private final String description;

	CommonCode(String code, Integer rawCode, String name, String description) {
		this.code = code;
		this.rawCode = rawCode;
		this.name = name;
		this.description = description;
	}
}
