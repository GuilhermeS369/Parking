package com.bootcamp.config;

import org.springframework.context.annotation.Bean;

import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bootcamp.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(buildApiInfo())
                .securityContexts(Arrays.asList(getSecurityContext()))
                .securitySchemes(Arrays.asList(basicAuthScheme()));

    }
    private SecurityScheme basicAuthScheme() {
        return new BasicAuth("basicAuth");
    }

    private SecurityContext getSecurityContext(){
        return SecurityContext.builder()
                .securityReferences(Arrays.asList(basicAuthReference()))
                .build();
    }

    private SecurityReference basicAuthReference(){
        return new SecurityReference("basicAuth", new AuthorizationScope[0]);
    }

    private ApiInfo buildApiInfo() {
        return new ApiInfoBuilder()
                .title("API Parking")
                .description("API do projeto Parking.")
                .version("0.1")
                .contact(new Contact("Guilherme",
                        "https://github.com/GuilhermeS369",
                        "Whatsapp: 11 963495981"))
                .build();

    }
}
