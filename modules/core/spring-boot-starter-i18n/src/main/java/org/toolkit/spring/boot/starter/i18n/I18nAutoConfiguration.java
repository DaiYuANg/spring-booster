//package org.toolkit.spring.boot.starter.i18n;
//
//import lombok.extern.slf4j.Slf4j;
//import org.jetbrains.annotations.NotNull;
//import org.springframework.boot.autoconfigure.AutoConfiguration;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.MessageSource;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.context.annotation.PropertySources;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
//
//@AutoConfiguration
//@EnableConfigurationProperties(I18nConfigurationProperties.class)
//@Slf4j
//@PropertySources({
//	@PropertySource(name = "en_US", value = "classpath:i18n/en_US.properties"),
//	@PropertySource(name = "zh_CN", value = "classpath:i18n/zh_CN.properties")
//})
//public class I18nAutoConfiguration implements WebMvcConfigurer {
//
//	@Bean
//	public LocaleChangeInterceptor localeChangeInterceptor() {
//		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
//		lci.setParamName("lang");
//		return lci;
//	}
//
//	@Override
//	public void addInterceptors(@NotNull InterceptorRegistry registry) {
//		registry.addInterceptor(localeChangeInterceptor());
//	}
//
//	@Bean
//	public MessageSource messageSource() {
//		return new CustomMessageSource();
//	}
//}
