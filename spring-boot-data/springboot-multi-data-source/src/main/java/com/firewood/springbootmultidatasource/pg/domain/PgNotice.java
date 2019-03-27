package com.firewood.springbootmultidatasource.pg.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PgNotice {
    private Long id;
    private String title;
    private String content;

    public PgNotice(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
