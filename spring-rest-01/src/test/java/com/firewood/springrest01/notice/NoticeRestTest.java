package com.firewood.springrest01.notice;

import com.firewood.springrest01.notice.domain.Notice;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NoticeRestTest {

    @Test
    public void getAllTest() {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList result = restTemplate.getForObject("http://localhost:8080/notice/get/all", ArrayList.class);
        System.out.println(result);
    }

    @Test
    public void getOneTest() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("id", "3");
        Notice notice = restTemplate.getForObject("http://localhost:8080/notice/get/one/{id}", Notice.class, params);
        System.out.println(notice);
    }


    @Test
    public void createTest() {
        RestTemplate restTemplate = new RestTemplate();
        Notice postNotice = new Notice("새롭게 추가", "내용입니다.");
        Notice notice = restTemplate.postForObject("http://localhost:8080/notice/create", postNotice, Notice.class);
        System.out.println(notice);
    }

    @Test
    public void updateTest() {
        RestTemplate restTemplate = new RestTemplate();
        Notice postNotice = new Notice("제목 변경", "내용 변경");
        Map<String, String> params = new HashMap<>();
        params.put("id", "4");
        restTemplate.put("http://localhost:8080/notice/update/{id}", postNotice, params);
    }

    @Test
    public void deleteTest() {
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("id", "1");
        restTemplate.delete("http://localhost:8080/notice/delete/{id}", params);
    }
}
