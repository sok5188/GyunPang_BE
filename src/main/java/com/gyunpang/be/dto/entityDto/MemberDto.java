package com.gyunpang.be.dto.entityDto;

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
public class MemberDto {
	private Integer userId;
	private Integer userType;
	private String name;
	private String nickname;
	private String username;
	private String password;
	private String refreshToken;
	private LocalDateTime tokenExpireDate;
	private String email;
	private Boolean useYn;
	private LocalDateTime createTime;
	private LocalDateTime modifyTime;
	private LocalDateTime deleteTime;
	private Long version;
}
