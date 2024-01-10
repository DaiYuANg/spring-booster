/* (C)2023*/
package org.spring.boost.persistence.listeners;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.persistence.base.BaseEntity;

@Slf4j
public class BaseEntityListener {

    @PrePersist
    public void prePersist(@NotNull BaseEntity baseEntity) {}

    @PreUpdate
    public void preUpdate(@NotNull BaseEntity baseEntity) {}
}