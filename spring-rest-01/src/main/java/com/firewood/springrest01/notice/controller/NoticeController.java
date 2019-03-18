package com.firewood.springrest01.notice.controller;

import com.firewood.springrest01.notice.domain.Notice;
import com.firewood.springrest01.notice.domain.builder.NoticeBuilder;
import com.firewood.springrest01.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Notice>> getAll() {
        return new ResponseEntity<>(noticeService.getAllNotice(), HttpStatus.OK);
    }

    @GetMapping(value = "/get/one/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Notice> getOne(@PathVariable Long id) {
        return noticeService
                .getOneNotice(id)
                .map(notice -> new ResponseEntity<>(notice, HttpStatus.OK))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Notice> createMemo(@RequestBody NoticeBuilder noticeBuilder) {
        try {
            return new ResponseEntity<>(noticeService.createNotice(noticeBuilder), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Notice> updateMemo(@PathVariable Long id, @RequestBody NoticeBuilder noticeBuilder) {
        return noticeService
                .updateNotice(id, noticeBuilder)
                .map(notice -> new ResponseEntity<>(notice, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteMemo(@PathVariable Long id) {
        try {
            noticeService.deleteNotice(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
