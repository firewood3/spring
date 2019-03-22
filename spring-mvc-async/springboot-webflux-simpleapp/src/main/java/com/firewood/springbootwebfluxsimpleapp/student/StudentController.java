package com.firewood.springbootwebfluxsimpleapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String getStudent(Model model) {
        Flux<Student> students = studentService.findAll();
        IReactiveDataDriverContextVariable react = new ReactiveDataDriverContextVariable(students, 1);
        model.addAttribute("students", react);
        return "student";
    }

    @PostMapping("/")
    public String addStudent(ServerWebExchange exchange, Model model) {
        Flux<Student> searched = exchange
                                .getFormData()
                                .map(form-> form.get("name"))
                                .flatMapMany(Flux::fromIterable)
                                .concatMap(studentService::search);

        IReactiveDataDriverContextVariable variable = new ReactiveDataDriverContextVariable(searched, 1);

        model.addAttribute("students", variable);
        return "student";
    }

    @GetMapping("/rest")
    @ResponseBody
    public Flux<Student> getRest() {
        return studentService.findAll();
    }

    @PostMapping("/rest")
    @ResponseBody
    public Flux<Student> searchRest(@RequestBody Mono<String> mono) {
        return mono.flatMapMany(studentService::search);
    }
}
