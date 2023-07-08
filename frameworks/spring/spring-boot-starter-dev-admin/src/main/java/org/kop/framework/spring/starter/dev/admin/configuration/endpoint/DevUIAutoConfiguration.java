package org.kop.framework.spring.starter.dev.admin.configuration.endpoint;

import com.google.gson.Gson;
import jakarta.annotation.Resource;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import org.thymeleaf.spring6.ISpringTemplateEngine;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@ConditionalOnWebApplication
@EnableWebMvc
@ComponentScan("org.kop.framework.spring.starter.dev.admin.endpoint.**")
public class DevUIAutoConfiguration implements WebMvcConfigurer {

    @Resource
    private ApplicationContext applicationContext;

    @Bean
    public ViewResolver templateResolver() {
        val viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine(htmlTemplateResolver()));
        viewResolver.setContentType("text/html");
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setViewNames(new String[]{"*.html"});
        return viewResolver;
    }

    private @NotNull ITemplateResolver htmlTemplateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("/templates/");
        resolver.setCacheable(false);
        resolver.setTemplateMode(TemplateMode.HTML);
        return resolver;
    }

    private @NotNull ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver);
        return engine;
    }

    @Bean
    @ConditionalOnMissingBean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }

    @Bean
    @ConditionalOnMissingBean
    public Gson gson(){
        return new Gson();
    }
}