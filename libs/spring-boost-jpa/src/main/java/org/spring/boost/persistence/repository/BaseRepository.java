package org.spring.boost.persistence.repository;

import org.spring.boost.persistence.base.BaseEntity;

public interface BaseRepository<T extends BaseEntity> extends AllinOneRepository<T, Long> {
}
