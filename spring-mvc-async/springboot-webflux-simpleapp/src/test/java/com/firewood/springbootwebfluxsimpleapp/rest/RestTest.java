package com.firewood.springbootwebfluxsimpleapp.rest;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

public class RestTest {

    @Test
    public void webClientTest() throws IOException {
        final String url = "http://localhost:8080/";
        WebClient.create(url)
                .get()
                .uri("/rest")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .flatMapMany(clientResponse -> clientResponse.bodyToFlux(String.class))
                .subscribe(System.out::println);

        System.in.read();
    }
}
