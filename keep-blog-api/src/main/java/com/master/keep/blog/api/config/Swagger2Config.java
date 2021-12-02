package com.master.keep.blog.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static org.springframework.web.bind.annotation.RequestMethod.*;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        /**
         * The rest api will always return 200
         */
        List<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>() {{
            add(new ResponseMessageBuilder().code(200).build());
        }};

        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(GET, responseMessages)
                .globalResponseMessage(POST, responseMessages)
                .globalResponseMessage(PUT, responseMessages)
                .globalResponseMessage(DELETE, responseMessages)
                .apiInfo(apiInfo())
                .select()

                /**
                 * 不指定监控package
                 */
                .apis(RequestHandlerSelectors.any())
                .paths(not(or(regex("/error.*"), regex("/actuator.*"))))//路径不监控
                .paths(regex("/.*")) // 对根下所有路径进行监控
                .build();

                //.apis(RequestHandlerSelectors.basePackage("com.master.keep.blog"))
                //.paths(PathSelectors.any())
                //.build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Keep Blog Api Doc")
                .contact(new Contact("Jay", "http://localhost:8080/test", "13641965227@163.com"))
                .build();

    }
}
