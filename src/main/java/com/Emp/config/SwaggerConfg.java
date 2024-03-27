package com.Emp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring4all.swagger.PathSelectors;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfg {
	@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
	.groupName("Employee_Details")
	.apiInfo(apiInfo())
	.select()
	.apis(RequestHandlerSelectors.basePackage("com.Emp.controller"))
	.paths(PathSelectors.any())
	.build();
	
	
	}

	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder().title("Employee Information")
				.description("Spring Api Doc")
				.version("1.0")
				.build();
	}
}
