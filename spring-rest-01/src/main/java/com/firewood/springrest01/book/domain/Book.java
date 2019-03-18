package com.firewood.springrest01.book.domain;

import lombok.*;
import org.springframework.hateoas.ResourceSupport;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends ResourceSupport {
    private String title;
    private String author;
    private String publisher;
}
