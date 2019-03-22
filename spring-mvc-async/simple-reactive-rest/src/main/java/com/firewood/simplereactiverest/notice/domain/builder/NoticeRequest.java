package com.firewood.simplereactiverest.notice.domain.builder;

import com.firewood.simplereactiverest.notice.domain.Notice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeRequest {

    private String title;
    private String content;

    public Notice build() {
        return new Notice(title, content);
    }
}
