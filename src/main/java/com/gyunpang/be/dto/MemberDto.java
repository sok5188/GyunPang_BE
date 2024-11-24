package com.gyunpang.be.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class MemberDto {
	@Getter
	@ToString
	@Builder(toBuilder = true)
	@EqualsAndHashCode
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Info {
		private int userId;
		private int userType;
		private String name;
		private String nickname;
		private String username;
		private String password;
		private String refreshToken;
		private LocalDateTime tokenExpireDate;
		private String email;
		private boolean useYn;
		private LocalDateTime createTime;
		private LocalDateTime modifyTime;
		private LocalDateTime deleteTime;
		private long version;
	}
}
