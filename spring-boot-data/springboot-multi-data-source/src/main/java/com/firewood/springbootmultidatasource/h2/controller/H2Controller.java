package com.firewood.springbootmultidatasource.h2.controller;

import com.firewood.springbootmultidatasource.h2.domain.H2Notice;
import com.firewood.springbootmultidatasource.h2.service.H2Service;
import com.firewood.springbootmultidatasource.mysql.domain.MysqlNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/h2")
public class H2Controller {

    private final H2Service h2Service;

    @Autowired
    public H2Controller(H2Service h2Service) {
        this.h2Service = h2Service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<H2Notice>> getAllNotice() {
        return new ResponseEntity<>(h2Service.getAllNotice(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNotice(@RequestBody H2Notice h2Notice) {
        if(h2Service.addNotice(h2Notice))
            return new ResponseEntity<>("h2 데이터 생성에 성공하였습니다.", HttpStatus.OK);
        else
            return new ResponseEntity<>("h2 데이터 생성에 실패하였습니다.", HttpStatus.EXPECTATION_FAILED);
    }
}
