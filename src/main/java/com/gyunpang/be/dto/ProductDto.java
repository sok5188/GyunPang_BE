package com.gyunpang.be.dto;

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
public class ProductDto {
	private Integer productId;
	private String name;
	private Integer price;
	private String color;
	private String size;
	private String IntegerroduceLink;
	private Integer userId;
	private Integer categoryId;
	private Boolean useYn;
	private LocalDateTime createTime;
	private LocalDateTime modifyTime;
	private LocalDateTime deleteTime;
	private Long version;
}
