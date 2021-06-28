package com.ssafy.eureka;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.eureka.interceptor.JWTInterceptor;

@SpringBootApplication
public class EurekaApplication extends SpringBootServletInitializer implements WebMvcConfigurer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EurekaApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class, args);
	}
	
	@Autowired
	private JWTInterceptor jwtInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtInterceptor).addPathPatterns(Arrays.asList("/home","/qna"));
//		.excludePathPatterns(Arrays.asList("/member/**", "/api/aptrest/**","/api/interest","/api/notice/get/**", "/api/member/join", "/api/member/findpwd","/swagger-ui.html"));
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("*")
		.allowedMethods("*")
		.allowedHeaders("*")
		.exposedHeaders("jwt-auth-access-token")
		.exposedHeaders("jwt-auth-refresh-token");
	}

}
