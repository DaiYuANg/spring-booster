package org.spring.boost.rbac.repository;

import org.spring.boost.persistence.repository.BaseRepository;
import org.spring.boost.rbac.entity.SysUser;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
@SuppressWarnings("unused")
public interface SysUserRepository<T extends SysUser> extends BaseRepository<T> {

  T findByUsername(String username);
}
