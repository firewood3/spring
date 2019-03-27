package com.firewood.springbootmultidatasource.mysql.controller;

import com.firewood.springbootmultidatasource.mysql.domain.MysqlNotice;
import com.firewood.springbootmultidatasource.mysql.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mysql")
public class MysqlController {

    private final MysqlService mysqlService;

    @Autowired
    public MysqlController(MysqlService mysqlService) {
        this.mysqlService = mysqlService;
    }

    @GetMapping("/state")
    public ResponseEntity<String> getState() {
        if(mysqlService.isConnected())
            return new ResponseEntity<>("mysql에 연결된 상태입니다.", HttpStatus.OK);
        else
            return new ResponseEntity<>("mysql에 연결되지 않은 상태입니다.", HttpStatus.OK);
    }

    @GetMapping("/connect")
    public ResponseEntity<String> getConnect() {
        if(mysqlService.connect())
            return new ResponseEntity<>("mysql에 연결 하였습니다.", HttpStatus.OK);
        else
            return new ResponseEntity<>("mysql 연결에 실패하였습니다.", HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/disconnect")
    public ResponseEntity<String> getDisconnect() {
        if(mysqlService.disconnect())
            return new ResponseEntity<>("mysql 연결을 해제 하였습니다.", HttpStatus.OK);
        else
            return new ResponseEntity<>("mysql 연결 해제에 실패하였습니다.", HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<MysqlNotice>> getAllNotice() {
        return mysqlService
                .getAllNotice()
                .map(mysqlNotices -> new ResponseEntity<>(mysqlNotices, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.EXPECTATION_FAILED));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNotice(@RequestBody MysqlNotice mysqlNotice) {
        if(mysqlService.addNotice(mysqlNotice))
            return new ResponseEntity<>("mysql 데이터 생성에 성공하였습니다.", HttpStatus.OK);
        else
            return new ResponseEntity<>("mysql 데이터 생성에 실패하였습니다.", HttpStatus.EXPECTATION_FAILED);
    }
}
