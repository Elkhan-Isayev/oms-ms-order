package com.oms.msorder.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MS-ORDER OMS(Order Management System) API")
                        .version("1.0")
                        .description("Order Service: Responsible for creating and querying orders.")
                        .contact(new Contact() // Контактная информация
                                .name("Elkhan")
                                .email("is.elxan@gmail.com"))
                        .license(new License() // Лицензия
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }

}
