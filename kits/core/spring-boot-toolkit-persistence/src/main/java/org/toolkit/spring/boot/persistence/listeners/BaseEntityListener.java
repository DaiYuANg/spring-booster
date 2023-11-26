package org.toolkit.spring.boot.persistence.listeners;

import cn.hutool.core.util.IdUtil;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.toolkit.spring.boot.persistence.base.BaseEntity;

@Slf4j
public class BaseEntityListener {

	@PrePersist
	public void prePersist(@NotNull BaseEntity baseEntity) {
//		baseEntity.setId(IdUtil.randomUUID());
		val version = Math.abs(baseEntity.hashCode());
		baseEntity.setVersion(String.valueOf(version));
	}

	@SneakyThrows
	@PreUpdate
	public void preUpdate(@NotNull BaseEntity baseEntity) {
		baseEntity.setVersion(String.valueOf(baseEntity.hashCode()));
	}
}
