package org.spring.boost.rbac.config;

import jakarta.persistence.EntityManagerFactory;
import org.spring.boost.rbac.repository.TestUser;
import org.spring.boost.rbac.repository.TestUserRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@TestConfiguration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = TestUserRepository.class)
@EntityScan(basePackageClasses = TestUser.class)
@EnableJpaAuditing
public class TestConfig {
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