package com.gyunpang.be.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class CouponCodeDto {
	@Getter
	@ToString
	@Builder(toBuilder = true)
	@EqualsAndHashCode
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Info {
		private int couponCodeId;
		private String code;
		private boolean issuedYn;
		private int memberId;
		private boolean useYn;
		private LocalDateTime createTime;
		private LocalDateTime modifyTime;
		private LocalDateTime deleteTime;
		private long version;
	}
}
