package org.spring.boost.rbac.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.persistence.model.PageQuery;
import org.spring.boost.rbac.converter.SysUserConverter;
import org.spring.boost.rbac.entity.RBACUser;
import org.spring.boost.rbac.repository.SysUserRepository;
import org.spring.boost.rbac.service.SysUserService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
@Slf4j
public class SysUserServiceImpl<T extends RBACUser> implements SysUserService {

  private final SysUserRepository<T> sysUserRepository;

  private final SysUserConverter sysUserConverter;

  public <Q extends PageQuery> Page<T> findAll(@NotNull Q query) {
    return sysUserRepository.findAll(query.pageable());
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return sysUserRepository.findByUsername(username)
      .map(sysUserConverter::sysUserToSysUserDetail)
      .orElseThrow(() -> new UsernameNotFoundException(username));
  }
}
