package com.firewood.simplereactiverest.hello;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
public class PersonService {

    ArrayList<Person> people = new ArrayList<>();

    public PersonService() {
        people.add(new Person("KIM", 33));
        people.add(new Person("LEE", 43));
        people.add(new Person("PARK", 22));
    }

    public Mono<ServerResponse> getAllPerson(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
                .body(BodyInserters.fromObject(people));
    }


}
