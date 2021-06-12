package com.ssafy.eureka;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//http://localhost/swagger-ui.html
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket qnaApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("qna-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}
	
	private Predicate<String> postPaths() {
		return or(regex("/product/.*"), regex("/.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("SSAFYHOUSE API")
				.description("<h3>SSAFYHOUSE API Reference for Developers</h3>Swagger를 이용한 HappyHouse API")
				.contact(new Contact("SSAFYHOUSE", "https://edu.ssafy.com", "ssafy@ssafy.com")).license("SSAFY License")
				.licenseUrl("https://www.ssafy.com/ksp/jsp/swp/etc/swpPrivacy.jsp").version("1.0").build();
	}
}
