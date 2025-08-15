package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docketSystem() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("系统API接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .build().apiInfo(apiInfo())
                .globalOperationParameters(getGlobalParameters());// 添加全局参数;
    }

    @Bean
    public Docket docketBusiness() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("业务API接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.web"))
                .build().apiInfo(apiInfo())
                .globalOperationParameters(getGlobalParameters());// 添加全局参数;
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

    /**
     * 添加Swagger的全局参数
     */
    private List<Parameter> getGlobalParameters() {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new ParameterBuilder()
                .name("Authorization") // 请求头的名称
                .description("Token") // 描述信息
                .modelRef(new ModelRef("string")) // 类型，这里是string类型
                .parameterType("header") // 参数类型，这里是header类型
                .required(true) // 是否必填，这里设置为false，表示非必填，可以根据实际需求设置
                .build());
        return parameters;
    }

}
