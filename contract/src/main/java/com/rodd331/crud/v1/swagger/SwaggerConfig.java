package com.rodd331.crud.v1.swagger;

import lombok.Generated;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Generated
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket crud() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.rodd331.crud.v1"))
                .build()
                .useDefaultResponseMessages(false)
                .apiInfo(metadata());
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Crud")
                .description("Crud documentation")
                .version("1.0.0")
                .build();
    }
}