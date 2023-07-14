package ru.prostor.cms.core.backend.config;

//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Contact;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.info.License;
//import io.swagger.v3.oas.models.servers.Server;
//import org.springdoc.core.GroupedOpenApi;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
//    @Bean
//    public GroupedOpenApi publicUserApi() {
//        return GroupedOpenApi.builder()
//                .group("Users")
//                .pathsToMatch("/users/**")
//                .build();
//    }
//
//    @Bean
//    public OpenAPI customOpenApi(
//            @Value("${application-description:#{'test'}}") String appDescription,
//            @Value("${application-version:#{'test'}}") String appVersion) {
//        return new OpenAPI()
//                .info(
//                        new Info()
//                                .filterTitle("Application API")
//                                .version(appVersion)
//                                .description(appDescription)
//                                .license(
//                                        getLicense()
//                                )
//                                .contact(
//                                        getContact()
//                                )
//                )
//                .servers(getServers());
//    }

//    private Contact getContact() {
//        return new Contact()
//                .name("username")
//                .email("test@gmail.com");
//    }
//
//    private License getLicense() {
//        return new License()
//                .name("Apache 2.0")
//                .url("http://springdoc.org");
//    }
//
//    private List<Server> getServers() {
//        return List.of(
//                new Server()
//                        .url("http://localhost:8080")
//                        .description("Dev service"),
//                new Server()
//                        .url("http://localhost:8082")
//                        .description("Beta service")
//        );
//    }
}
