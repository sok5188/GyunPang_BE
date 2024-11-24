package com.gyunpang.be.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class SellDto {
	@Getter
	@ToString
	@Builder(toBuilder = true)
	@EqualsAndHashCode
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Info {
		private int sellId;
		private int sellStatus;
		private int memberId;
		private int orderId;
		private boolean useYn;
		private LocalDateTime createTime;
		private LocalDateTime modifyTime;
		private LocalDateTime deleteTime;
		private long version;
	}
}
