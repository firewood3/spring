package com.firewood.simplereactiverest.notice.service;

import com.firewood.simplereactiverest.notice.domain.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class NoticeHandler {

    private final NoticeRepository noticeRepository;

    @Autowired
    public NoticeHandler(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public Mono<ServerResponse> hello(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, Flux!"));
    }

    public Mono<ServerResponse> getAllNotice(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
                .body(BodyInserters.fromObject(noticeRepository.findAll()));
    }

    public Mono<ServerResponse> getOneNotice(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
                .body(BodyInserters.fromObject(noticeRepository.findById(Long.parseLong(request.pathVariable("id")))));
    }

    public Mono<ServerResponse> createNotice(ServerRequest request) {
        Optional<Object> title = request.attribute("title");
        System.out.println(title.toString());

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8)
                .body(BodyInserters.empty());
    }


//    public Notice createNotice(NoticeRequest noticeBuilder) {
//        return noticeRepository.save(noticeBuilder.build());
//    }
//
//    @Transactional
//    public Optional<Notice> updateNotice(Long id, NoticeRequest noticeBuilder) throws EntityNotFoundException {
//        Optional<Notice> notice = noticeRepository.findById(id);
//        if(notice.isPresent()) {
//            notice.get().setTitle(noticeBuilder.getTitle());
//            notice.get().setContent(noticeBuilder.getContent());
//        }
//        return notice;
//    }
//
//    public void deleteNotice(Long id) throws EntityNotFoundException{
//        noticeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
//        noticeRepository.deleteById(id);
//    }
}
