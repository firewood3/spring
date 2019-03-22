package com.firewood.springbootmvcasyncemitter.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/body")
    @ResponseBody
    public List body() {
        return personService.findAllPerson();
    }

    @GetMapping("/emitter")
    public ResponseBodyEmitter emitter() {
        final ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(()->{
            ArrayList<Person> allPerson = personService.findAllPerson();
            try {
                for(Person person : allPerson) {
                    System.out.println("Thread name : " + Thread.currentThread().getName());
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

    @GetMapping("/sseEmitter")
    public SseEmitter sseEmitter() {
        final SseEmitter sseEmitter = new SseEmitter();
        this.executeEmitter(sseEmitter);
        return sseEmitter;
    }

    private void executeEmitter(ResponseBodyEmitter emitter) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(()->{
            ArrayList<Person> allPerson = personService.findAllPerson();
            try {
                for(Person person : allPerson) {
                    Thread.sleep(1000);
                    emitter.send(person);
                }
                emitter.complete();
            } catch (IOException e) {
                e.printStackTrace();
                emitter.completeWithError(e);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
