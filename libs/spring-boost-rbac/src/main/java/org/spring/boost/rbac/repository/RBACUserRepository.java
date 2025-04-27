package org.spring.boost.rbac.repository;

import org.spring.boost.persistence.repository.BaseRepository;
import org.spring.boost.rbac.entity.RBACUser;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
@SuppressWarnings("unused")
public interface RBACUserRepository<T extends RBACUser> extends BaseRepository<T> {

  Optional<T> findByUsername(String username);
}
