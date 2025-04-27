package org.spring.boost.rbac.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.spring.boost.rbac.converter.RBACUserConverter;
import org.spring.boost.rbac.entity.RBACUser;
import org.spring.boost.rbac.repository.RBACUserRepository;
import org.spring.boost.rbac.service.RBACUserService;
import org.spring.boost.rbac.service.impl.DefaultUserService;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.security.core.userdetails.UserDetailsService;

@AutoConfiguration
@Slf4j
@SuppressWarnings("unchecked")
public class RBACUserAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean(UserDetailsService.class)
  RBACUserService sysUserService(
    JpaRepositoryFactory jpaRepositoryFactory,
    RBACUserConverter RBACUserConverter
  ) {
    val sysUserRepository = jpaRepositoryFactory.getRepository(RBACUserRepository.class);
    return new DefaultUserService<RBACUser>(sysUserRepository, RBACUserConverter);
  }
}
