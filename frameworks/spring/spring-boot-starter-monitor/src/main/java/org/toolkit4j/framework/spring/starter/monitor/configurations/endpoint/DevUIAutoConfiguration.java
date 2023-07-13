package org.toolkit4j.framework.spring.starter.monitor.configurations.endpoint;

import com.google.gson.Gson;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.val;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
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

import java.net.InetAddress;

@Configuration
@ConditionalOnWebApplication
@EnableWebMvc
@ComponentScan("org.kop.framework.spring.starter.dev.admin.endpoint.**")
//@EnableJpaRepositories("org.kop.framework.spring.starter.dev.admin.endpoint.repos")
@EntityScan({"org.kop.framework.spring.starter.dev.admin.endpoint.entities"})
public class DevUIAutoConfiguration implements WebMvcConfigurer {

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private Environment env;

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
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    @ConditionalOnMissingBean
    public Gson gson() {
        return new Gson();
    }

    @SneakyThrows
    @Bean
    public ServerBasicInfo serverAccessAddress() {
        return ServerBasicInfo.builder()
                .contextPath(env.getProperty("server.context-path", "/"))
                .port(env.getProperty("server.port", String.valueOf(8080)))
                .host(InetAddress.getLocalHost().getHostAddress())
                .build();
    }

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }

//    @Bean
//    public DataSource devAdminDataSource() {
//        return DataSourceBuilder.create().driverClassName("org.h2.Driver").type(JdbcDataSource.class)
//                .url("jdbc:h2:memory:default")
//                .build();
//    }
}
