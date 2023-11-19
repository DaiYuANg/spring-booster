package org.toolkit.spring.boot.website.configuration

import jakarta.annotation.PostConstruct
import jakarta.annotation.Resource
import lombok.extern.slf4j.Slf4j
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.toolkit.spring.boot.utils.kotlin.annotation.KotlinSlf4j.Companion.log
import org.toolkit.spring.boot.website.interceptor.AccessInterceptor
import org.toolkit.spring.boot.website.interceptor.LanguageInterceptor
import org.toolkit.spring.boot.website.resolver.IndexFallbackResolver

@Configuration
@Slf4j
class WebMvcConfiguration : WebMvcConfigurer {
    @Resource
    private lateinit var languageInterceptor: LanguageInterceptor

    @Resource
    private lateinit var accessInterceptor: AccessInterceptor

    @PostConstruct
    fun init() {
        log.atInfo().log("web mvc configuration execute")
    }

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/**")
            .addResourceLocations("classpath:/static/")
            .setCachePeriod(0)
            .resourceChain(true)
            .addResolver(IndexFallbackResolver())
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(languageInterceptor)
        registry.addInterceptor(accessInterceptor)
    }

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/")
            .setViewName("forward:/index.html")
    }
}
