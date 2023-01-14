package com.evaluaciontecnica.carritocompra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Set;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){

        return new Docket(DocumentationType.SWAGGER_2)
                .consumes(Set.of(MediaType.APPLICATION_JSON.toString()))
                .produces(Set.of(MediaType.APPLICATION_JSON.toString()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.evaluaciontecnica.carritocompra.web.controller"))
                .build();

    }


}
