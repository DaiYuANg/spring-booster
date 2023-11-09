package org.toolkit.spring.boot.minio.persistence.configuration;

import jakarta.annotation.Resource;
import java.util.HashMap;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@AutoConfiguration
@Slf4j
@EnableConfigurationProperties({
	MinioDataSourceConfigurationProperties.class,
	MinioPersistenceConfigurationProperties.class
})
@EnableJpaRepositories(
		basePackages = "org.toolkit.spring.boot.starter.minio",
		entityManagerFactoryRef = "minioEntityManager",
		transactionManagerRef = "minioTransactionManager")
public class MinioDatasourceAutoConfiguration {

	@Resource
	private Environment env;

	@Resource
	private MinioDataSourceConfigurationProperties minioDataSourceConfigurationProperties;

	@Bean("minioDatasource")
	public DataSource minioDatasource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		//        dataSource.setDriverClassName(
		//                minioDataSourceConfigurationProperties.getDriverClassName());
		//        dataSource.setUrl(minioDataSourceConfigurationProperties.getUrl());
		//        dataSource.setUsername(minioDataSourceConfigurationProperties.getUsername());
		//        dataSource.setPassword(minioDataSourceConfigurationProperties.getPassword());
		return dataSource;
	}

	@Bean("minioEntityManager")
	public LocalContainerEntityManagerFactoryBean minioEntityManager() {
		val em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(minioDatasource());
		em.setPackagesToScan("org.toolkit.spring.boot.starter.minio.entity");
		val vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		val properties = new HashMap<String, Object>();
		properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
		em.setJpaPropertyMap(properties);
		return em;
	}

	@Bean("minioTransactionManager")
	public PlatformTransactionManager minioTransactionManager() {
		val transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(minioEntityManager().getObject());
		return transactionManager;
	}
}
