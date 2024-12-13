package org.spring.boost.persistence.autoconfigure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@RequiredArgsConstructor
public class QueryDSLAutoConfiguration {
  private final EntityManager em;

  @Bean
  JPAQueryFactory jpaQueryFactory() {
    return new JPAQueryFactory(em);
  }
}
