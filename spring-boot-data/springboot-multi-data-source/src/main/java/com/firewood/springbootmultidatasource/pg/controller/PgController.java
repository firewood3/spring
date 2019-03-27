package com.firewood.springbootmultidatasource.pg.controller;

import com.firewood.springbootmultidatasource.pg.domain.PgNotice;
import com.firewood.springbootmultidatasource.pg.service.PgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pg")
public class PgController {

    private final PgService pgService;

    @Autowired
    public PgController(PgService pgService) {
        this.pgService = pgService;
    }

    @GetMapping("/state")
    public ResponseEntity<String> getState() {
        if(pgService.isConnected())
            return new ResponseEntity<>("pg에 연결된 상태입니다.", HttpStatus.OK);
        else
            return new ResponseEntity<>("pg에 연결되지 않은 상태입니다.", HttpStatus.OK);
    }

    @GetMapping("/connect")
    public ResponseEntity<String> getConnect() {
        if(pgService.connect())
            return new ResponseEntity<>("pg에 연결 하였습니다.", HttpStatus.OK);
        else
            return new ResponseEntity<>("pg 연결에 실패하였습니다.", HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/disconnect")
    public ResponseEntity<String> getDisconnect() {
        if(pgService.disconnect())
            return new ResponseEntity<>("pg 연결을 해제 하였습니다.", HttpStatus.OK);
        else
            return new ResponseEntity<>("pg 연결 해제에 실패하였습니다.", HttpStatus.EXPECTATION_FAILED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PgNotice>> getAllNotice() {
        return pgService
                .getAllNotice()
                .map(pgNotices -> new ResponseEntity<>(pgNotices, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.EXPECTATION_FAILED));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNotice(@RequestBody PgNotice pgNotice) {
        if(pgService.addNotice(pgNotice))
            return new ResponseEntity<>("pg 데이터 생성에 성공하였습니다.", HttpStatus.OK);
        else
            return new ResponseEntity<>("pg 데이터 생성에 실패하였습니다.", HttpStatus.EXPECTATION_FAILED);
    }
}
