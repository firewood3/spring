package com.firewood.async.controller;

import com.firewood.async.domain.Person;
import com.firewood.async.service.AsyncService;
import com.firewood.async.util.Delayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class AsyncController {

    private final Logger logger = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    private AsyncService asyncService;

    @Autowired
    @Qualifier("myThreadPool")
    private TaskExecutor taskExecutor;

    @Autowired
    @Qualifier("myListenable")
    private AsyncListenableTaskExecutor asyncListenableTaskExecutor;

    @GetMapping("/sync")
    public String sync() {
        Delayer.threadSleep();
        return "sync";
    }

    @GetMapping("/async-callable")
    public Callable<String> asyncCallable() {
        return ()->{
            Delayer.threadSleep();
            return "async-callable";
        };
    }

    @GetMapping("/async-deferredResult")
    public DeferredResult<String> asyncDeferredResult() {
        DeferredResult<String> result = new DeferredResult<>();
        taskExecutor.execute(()->{
            Delayer.threadSleep();
            result.setResult("async-deferredResult");
        });
        return result;
    }

    @GetMapping("/async-completableFuture")
    public CompletableFuture<String> asyncCompletableFuture() {
        return CompletableFuture.supplyAsync(()->{
            Delayer.threadSleep();
            return "/async-completableFuture";
        }, taskExecutor);
    }

    @GetMapping("/async-listenableFuture")
    public ListenableFuture<String> asyncListenableFuture() {
        return asyncListenableTaskExecutor.submitListenable(()->{
            Delayer.threadSleep();
            return "async-listenableFuture";
        });
    }

    @GetMapping("/emitter")
    public ResponseBodyEmitter emitter() {
        final ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        ArrayList<Person> allPerson = asyncService.findAllPerson();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(()->{
            try {
                for(Person person : allPerson) {
                    emitter.send(person);
                }
                emitter.complete();
            } catch (IOException e) {
                e.printStackTrace();
                emitter.completeWithError(e);
            }
        });
        return emitter;
    }


}
