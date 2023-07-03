package com.ripplestreet.studentinforest.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@ConditionalOnWebApplication
@AutoConfigureAfter(WebMvcAutoConfiguration.class)
public class StudentConfig {
	 @Bean
	    public Logger logger() {
	        return LogManager.getLogger();
	    }
	 
	 
//	 @Bean
//	    public Docket api() {
//	        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//	                .apis(RequestHandlerSelectors.basePackage("com.ripplestreet")).paths(PathSelectors.any()).build();
//	    }
//
//	 
//
//	    private ApiInfo apiInfo() {
//	        return new ApiInfoBuilder().title("Student info")
//	                .description("This api can be used to get student_info information").build();
//	    }
//
//	 
//
//	    @Bean
//	    public WebMvcConfigurer corsConfigurer() {
//	        return new WebMvcConfigurer() {
//	            @Override
//	            public void addCorsMappings(CorsRegistry registry) {
//	                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
//	            }
//	        };
//	    }
	}

