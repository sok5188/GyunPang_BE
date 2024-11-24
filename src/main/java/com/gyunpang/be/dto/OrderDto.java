package com.gyunpang.be.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class OrderDto {
	@Getter
	@ToString
	@Builder(toBuilder = true)
	@EqualsAndHashCode
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Info {
		private int orderId;
		private int count;
		private int orderStatus;
		private int payPrice;
		private int memberId;
		private int productId;
		private int couponId;
		private boolean useYn;
		private LocalDateTime createTime;
		private LocalDateTime modifyTime;
		private LocalDateTime deleteTime;
		private long version;
	}
}
