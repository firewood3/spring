package com.firewood.springbootmultidatasource.h2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class H2Notice {
    private Long id;
    private String title;
    private String content;

    public H2Notice(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
