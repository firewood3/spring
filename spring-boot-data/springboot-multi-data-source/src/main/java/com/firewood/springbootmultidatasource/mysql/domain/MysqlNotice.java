package com.firewood.springbootmultidatasource.mysql.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MysqlNotice {
    private Long id;
    private String title;
    private String content;

    public MysqlNotice(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
