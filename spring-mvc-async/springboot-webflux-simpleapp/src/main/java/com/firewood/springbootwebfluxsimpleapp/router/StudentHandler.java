package com.firewood.springbootwebfluxsimpleapp.router;

import com.firewood.springbootwebfluxsimpleapp.student.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentHandler {

    private List<Student> students = new ArrayList<>();

    public StudentHandler() {
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

//    public Mono<ServerResponse> getAll(){
//        return (Mono<ServerResponse>) ServerResponse.ok().body(students, Student.class);
//    }
}
