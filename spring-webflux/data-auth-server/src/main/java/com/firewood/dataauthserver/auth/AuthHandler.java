package com.firewood.dataauthserver.auth;

import com.firewood.dataauthserver.auth.model.LoginRequest;
import com.firewood.dataauthserver.auth.model.TokenResponse;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class AuthHandler {

    public Mono<ServerResponse> authHandler(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, Flux!"));
    }

    public Mono<ServerResponse> statusHandler(ServerRequest request) {
        List<String> authorization = request.headers().header("Authorization");

        System.out.println(authorization);

        if(authorization.get(0) != null && authorization.get(0).equals("Bearer good-web-token-1234567890")) {
            return ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.empty());
        } else {
            return ServerResponse
                    .status(401)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.empty());
        }
    }

    public Mono<ServerResponse> loginHandler(ServerRequest request) {
        return request
                .bodyToMono(LoginRequest.class)
                .flatMap(loginRequest -> this.getRes(loginRequest.getUserId()));
    }

    private Mono<ServerResponse> getRes(String value) {
        System.out.println(value);
        if(value.equals("test")) {
            return ServerResponse.ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromObject(new TokenResponse("good-web-token-1234567890")));
        } else {
            return ServerResponse
                    .badRequest()
                    .body(BodyInserters.empty());
        }
    }
}
