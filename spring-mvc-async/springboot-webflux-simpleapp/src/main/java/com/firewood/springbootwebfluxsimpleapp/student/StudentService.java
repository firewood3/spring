package com.firewood.springbootwebfluxsimpleapp.student;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;

@Service
public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student("kim rara", 20));
        students.add(new Student("kim sin young", 52));
        students.add(new Student("lee sun sin", 21));
        students.add(new Student("lee san", 21));
        students.add(new Student("park chan ho", 22));
        students.add(new Student("hong gil dong", 31));
        students.add(new Student("ki soun young", 22));
        students.add(new Student("son hug min", 22));
        students.add(new Student("kang ho dong", 22));
    }

    public Flux<Student> findAll() {
        return Flux.fromIterable(students).delayElements(Duration.ofSeconds(2));
    }

    public Flux<Student> search(String name) {
        return Flux
                .fromStream(students.stream()
                .filter(student -> student.getName().startsWith(name))).delayElements(Duration.ofSeconds(2));
    }
}
