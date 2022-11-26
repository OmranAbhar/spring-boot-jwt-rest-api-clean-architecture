package com.clean.app;

import com.clean.app.common.mediator.core.IMediator;
import com.clean.app.common.mediator.spring.SpringMediator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication()
@ComponentScan("com.*")
@PropertySource("classpath:application.properties")
@Configuration
@EnableWebSecurity
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args)
    {
        SpringApplication.run(Application.class, args);
    }

    public String PROFILE = null;
    private static String CONFIG_LOCATION = null;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Grab the active profile from the servlet conext
        PROFILE = servletContext.getInitParameter("spring.profiles.active");
        CONFIG_LOCATION = servletContext.getInitParameter("spring.config.path");

        super.onStartup(servletContext);
    }

    // @Bean
    // public PropertySourcesPlaceholderConfigurer
    // propertySourcesPlaceholderConfigurer() {
    // PropertySourcesPlaceholderConfigurer properties = new
    // PropertySourcesPlaceholderConfigurer();
    // properties.setLocation(new
    // FileSystemResource("D:\\Softwares\\apache-tomcat-8.5.57\\conf\\presentation\\application.properties"));
    // properties.setIgnoreResourceNotFound(false);
    // return properties;
    // }

    @Bean
    public WebMvcConfigurer CorsConfiguration() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**").allowedOrigins("*").allowedMethods("*").allowedHeaders("*");
            }
        };
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }


    @Autowired
    ApplicationContext applicationContext;
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public IMediator mediator(){
        return new SpringMediator(applicationContext,"com.clean.app");
    }
}
