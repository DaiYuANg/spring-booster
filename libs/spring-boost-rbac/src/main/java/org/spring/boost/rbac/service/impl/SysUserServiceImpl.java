package org.spring.boost.rbac.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.persistence.model.PageQuery;
import org.spring.boost.rbac.entity.SysUser;
import org.spring.boost.rbac.repository.SysUserRepository;
import org.spring.boost.rbac.service.SysUserService;
import org.springframework.data.domain.Page;

@RequiredArgsConstructor
@Slf4j
public class SysUserServiceImpl<T extends SysUser> implements SysUserService {

  private final SysUserRepository<T> sysUserRepository;

  public <Q extends PageQuery> Page<T> findAll(@NotNull Q query) {
    return sysUserRepository.findAll(query.pageable());
  }
}
