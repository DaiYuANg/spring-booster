package org.spring.boost.rbac.autoconfigure;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

@AutoConfiguration
@Slf4j
public class RBACAutoConfiguration {

  @Bean(name = "RBACJpaRepositoryFactory")
  JpaRepositoryFactory jpaRepositoryFactory(EntityManager entityManager){
    return new JpaRepositoryFactory(entityManager);
  }
}
