package com.bootcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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
                .apiInfo(buildApiInfo());

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
