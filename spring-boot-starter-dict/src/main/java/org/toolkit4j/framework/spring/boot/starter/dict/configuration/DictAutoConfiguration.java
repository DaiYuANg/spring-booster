package org.toolkit4j.framework.spring.boot.starter.dict.configuration;

import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("org.toolkit4j.framework.spring.boot.starter.dict.**.*")
@EnableJpaRepositories("org.toolkit4j.framework.spring.boot.starter.dict.repos")
@EntityScan({"org.toolkit4j.framework.spring.boot.starter.dict"})
@EnableConfigurationProperties(DictConfigurationProperties.class)
public class DictAutoConfiguration {
	@Resource
	private DictConfigurationProperties dictConfigurationProperties;

	@Resource
	private ApplicationContext context;

	@Bean
	@ConditionalOnMissingBean(value = {Gson.class})
	public Gson gson() {
		return new Gson();
	}

	//	@Bean
	//	public DictScanner dictScanner() {
	//		return new DefaultDictScannerImpl();
	//	}

	//    @Bean
	//    public Cache<String, DictFunctional> jc() {
	//        javax.cache.CacheManager jCacheManager = Caching.getCachingProvider().getCacheManager();
	//        MutableConfiguration<String, DictFunctional> cacheConfig = new MutableConfiguration<>();
	//        cacheConfig.setStatisticsEnabled(true);
	//        cacheConfig.setTypes(String.class, DictFunctional.class);
	//        return jCacheManager.createCache("dictCache", cacheConfig);
	//    }
}
