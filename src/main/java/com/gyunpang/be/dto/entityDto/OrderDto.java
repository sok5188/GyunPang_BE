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
public class OrderDto {
	private Integer orderId;
	private Integer count;
	private Integer orderStatus;
	private Integer payPrice;
	private Integer userId;
	private Integer productId;
	private Integer couponId;
	private Boolean useYn;
	private LocalDateTime createTime;
	private LocalDateTime modifyTime;
	private LocalDateTime deleteTime;
	private Long version;
}
