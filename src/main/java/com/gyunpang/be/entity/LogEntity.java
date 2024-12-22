package com.gyunpang.be.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "`log`")
@DynamicUpdate
@SuperBuilder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SQLRestriction("use_yn = true")
public class LogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "log_id")
	private int logId;

	@Column(name = "request_id")
	private String requestId;

	@Column(name = "status_code")
	private String statusCode;

	@Column(name = "type")
	private String type;

	@Column(name = "uri")
	private String uri;

	@Column(name = "route_id")
	private String routeId;

	@Column(name = "route")
	private String route;

	@Column(name = "method")
	private String method;

	@Column(name = "body")
	private String body;

	@Column(name = "create_dt")
	private LocalDateTime createDateTime;

	@Column(name = "user_id")
	private String userId;
}
