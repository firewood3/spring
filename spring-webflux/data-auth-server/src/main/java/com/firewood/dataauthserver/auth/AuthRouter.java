package com.firewood.dataauthserver.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class AuthRouter {

    @Bean
    RouterFunction<ServerResponse> authRoute(AuthHandler authHandler) {
        return RouterFunctions
                .route(GET("/auth").and(accept(MediaType.TEXT_PLAIN)),
                        authHandler::authHandler)
                .andRoute(POST("/auth/login").and(accept(APPLICATION_JSON).and(contentType(APPLICATION_JSON))),
                        authHandler::loginHandler)
                .andRoute(GET("/auth/status"),
                        authHandler::statusHandler);
    }
}
