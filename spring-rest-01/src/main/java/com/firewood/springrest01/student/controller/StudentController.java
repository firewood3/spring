package com.firewood.springrest01.student.controller;

import com.firewood.springrest01.student.domain.Student;
import com.firewood.springrest01.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(value = "/view/student")
    public String getStudent(Model model) {
        model.addAttribute("xmlStudent", new Student(1, "LEE"));
        return "student";
    }

    @GetMapping(value = "/response/student")
    @ResponseBody
    public Student getHttpConverterStudent() {
        return new Student(10, "PARK");
    }
}
