package com.gyunpang.be.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
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

	@CreatedDate
	@Column(name = "create_dt")
	private LocalDateTime createTime;

	@LastModifiedDate
	@Column(name = "modify_dt")
	private LocalDateTime modifyTime;

	@Column(name = "delete_dt")
	private LocalDateTime deleteTime;

	@Version
	private Long version;

	@PrePersist
	public void prePersist() {
		this.useYn = true;
	}

	@PreUpdate
	public void preUpdate() {
		this.useYn = true;
	}
}
