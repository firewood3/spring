package com.firewood.springrest01.book.controller;

import com.firewood.springrest01.book.domain.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/hateoas")
public class BookController {

    @GetMapping("/book")
    public ResponseEntity<Book> getBook() {
        Book book = new Book("스프링", "java", "people");
        book.add(linkTo(methodOn(BookController.class).getBook()).withSelfRel());
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
