package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docketSystem() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("系统API接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .build().apiInfo(apiInfo());
    }

    @Bean
    public Docket docketBusiness() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("业务API接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.web"))
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot项目API文档")
                .description("API文档详细描述")
                .termsOfServiceUrl("http://localhost:5555/doc.html")// 服务URL
                .version("1.0.0")
                .contact(new Contact("曾衍育", "http://example.com", "1194314874@qq.com"))
                .build();
    }
}
