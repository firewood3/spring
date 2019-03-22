package com.firewood.simplereactiverest.notice.controller;

import com.firewood.simplereactiverest.notice.service.NoticeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class NoticeRouter {

    @Bean
    RouterFunction<ServerResponse> getAll(NoticeHandler noticeHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/notice/get/all").and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8))
                , noticeHandler::getAllNotice);
    }

    @Bean
    RouterFunction<ServerResponse> getOne(NoticeHandler noticeHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/notice/get/one/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8))
                , noticeHandler::getOneNotice);
    }

    @Bean
    RouterFunction<ServerResponse> create(NoticeHandler noticeHandler) {
        return RouterFunctions.route(RequestPredicates.POST("/notice/create").and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8))
                , noticeHandler::createNotice);
    }
}
