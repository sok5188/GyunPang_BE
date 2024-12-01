package com.gyunpang.be.entity;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuperBuilder
@NoArgsConstructor
@Getter
public class BaseEntity {
	@Column(name = "use_yn")
	private Boolean useYn;

	@Column(name = "create_dt")
	private LocalDateTime createTime;

	@Column(name = "modify_dt")
	private LocalDateTime modifyTime;

	@Column(name = "delete_dt")
	private LocalDateTime deleteTime;

	@Version
	private Long version;
}
