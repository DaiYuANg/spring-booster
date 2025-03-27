package org.spring.boost.rbac.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.spring.boost.rbac.converter.SysUserConverter;
import org.spring.boost.rbac.entity.SysUser;
import org.spring.boost.rbac.repository.SysUserRepository;
import org.spring.boost.rbac.service.SysUserService;
import org.spring.boost.rbac.service.impl.SysUserServiceImpl;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

@AutoConfiguration
@Slf4j
@SuppressWarnings("unchecked")
public class SysUserAutoConfiguration {

  @Bean
  @ConditionalOnMissingBean(SysUserService.class)
  SysUserService sysUserService(
    JpaRepositoryFactory jpaRepositoryFactory,
    SysUserConverter sysUserConverter
  ) {
    val sysUserRepository = jpaRepositoryFactory.getRepository(SysUserRepository.class);
    return new SysUserServiceImpl<SysUser>(sysUserRepository, sysUserConverter);
  }
}
