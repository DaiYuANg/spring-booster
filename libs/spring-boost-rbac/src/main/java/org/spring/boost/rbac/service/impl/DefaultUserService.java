package org.spring.boost.rbac.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.spring.boost.persistence.model.PageQuery;
import org.spring.boost.rbac.converter.RBACUserConverter;
import org.spring.boost.rbac.entity.RBACUser;
import org.spring.boost.rbac.repository.RBACUserRepository;
import org.spring.boost.rbac.service.RBACUserService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
@Slf4j
public class DefaultUserService<T extends RBACUser> implements RBACUserService {

  private final RBACUserRepository<T> RBACUserRepository;

  private final RBACUserConverter RBACUserConverter;

  public <Q extends PageQuery> Page<T> findAll(@NotNull Q query) {
    return RBACUserRepository.findAll(query.pageable());
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return RBACUserRepository.findByUsername(username)
      .map(RBACUserConverter::sysUserToSysUserDetail)
      .orElseThrow(() -> new UsernameNotFoundException(username));
  }
}
