package com.coursework.bookstore_graphql_client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GraphQLClientConfig {

    @Value("${bearer}")
    private String token;

    @Bean
    public HttpGraphQlClient httpGraphQlClient() {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.hardcover.app/v1/graphql")
                .defaultHeader("Authorization", "Bearer " + token)
                .build();
        return HttpGraphQlClient.builder(webClient).build();
    }

}
