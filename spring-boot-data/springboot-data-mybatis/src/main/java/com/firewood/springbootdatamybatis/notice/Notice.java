package com.firewood.springbootdatamybatis.notice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
    private Long id;
    private String title;
    private String content;
}
