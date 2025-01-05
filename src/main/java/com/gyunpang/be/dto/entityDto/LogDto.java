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
public class LogDto {
	private String requestId;
	private String statusCode;
	private String type;
	private String uri;
	private String routeId;
	private String route;
	private String method;
	private String body;
	private LocalDateTime createDateTime;
	private String userId;
}
