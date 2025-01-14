package org.shifang.usermanage.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Knife4jConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("UserManagement API")
                        .version("1.0")
                        .description("UserManagement API的接口文档"));
    }

    @Bean //接口分组
    public GroupedOpenApi userAPI() {
        return GroupedOpenApi.builder().group("用户信息管理").
                pathsToMatch("/user/**").
                build();
    }

    @Bean //接口分组
    public GroupedOpenApi systemAPI() {
        return GroupedOpenApi.builder().group("登陆信息管理").
                pathsToMatch("/login/**").
                build();
    }
}