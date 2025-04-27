package org.spring.boost.rbac.repository;

import jakarta.annotation.Resource;
import jakarta.persistence.EntityManagerFactory;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.spring.boost.rbac.entity.RBACUser;
import org.spring.boost.rbac.repository.TestUserRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RBACUserRepositoryTest.TestConfig.class})
class RBACUserRepositoryTest {

  @Resource
  private TestUserRepository testUserRepository;

  @Test
  void findByUsername() {
    val user = new TestUser();
    user.setUsername("username");
    user.setPassword("password");
    testUserRepository.save(user);
    val findUser = testUserRepository.findByUsername("username");
    Assertions.assertTrue(findUser.isPresent());
  }

  @TestConfiguration
  @EnableTransactionManagement
  @EnableJpaRepositories(basePackageClasses = TestUserRepository.class)
  @EntityScan(basePackageClasses = TestUser.class)
  static class TestConfig {
    @Bean
    public DataSource dataSource() {
      return DataSourceBuilder.create()
        .driverClassName("org.h2.Driver")
        .url("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=false")
        .username("sa")
        .password("")
        .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
      LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
      emf.setDataSource(dataSource);
      emf.setPackagesToScan(TestUser.class.getPackageName());
      emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

      Properties jpaProperties = new Properties();
      jpaProperties.put("hibernate.hbm2ddl.auto", "update"); // 自动建表
      jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
      jpaProperties.put("hibernate.show_sql", "true");
      emf.setJpaProperties(jpaProperties);

      return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
      return new JpaTransactionManager(emf);
    }
  }
}
