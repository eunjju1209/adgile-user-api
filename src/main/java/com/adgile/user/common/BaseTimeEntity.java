package com.adgile.user.common;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.ZonedDateTime;
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseTimeEntity {

	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
	private ZonedDateTime deletedAt;

	@PrePersist
	public void prePersist() {
		this.createdAt = ZonedDateTime.now();
	}

	@PreUpdate
	public void preUpdate() {
		this.updatedAt = ZonedDateTime.now();
	}

	public void updateDelete() {
		this.deletedAt = ZonedDateTime.now();
	}
}
