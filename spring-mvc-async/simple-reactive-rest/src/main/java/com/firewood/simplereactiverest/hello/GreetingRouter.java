package com.firewood.simplereactiverest.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN))
                        , greetingHandler::hello);
    }

    @Bean RouterFunction<ServerResponse> getPerson(PersonService personService) {
        return RouterFunctions.route(RequestPredicates.GET("/people/get/all").and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8))
                , personService::getAllPerson);
    }
}
