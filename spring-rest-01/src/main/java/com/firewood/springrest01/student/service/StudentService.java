package com.firewood.springrest01.student.service;

import com.firewood.springrest01.student.domain.Student;
import org.springframework.stereotype.Service;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @XmlElement(name = "student")
    private List<Student> studentList = new ArrayList<>();

    public StudentService() {
        studentList.add(new Student(1, "KIM"));
        studentList.add(new Student(2, "LEE"));
        studentList.add(new Student(3, "PARK"));
    }

    public List findAll() {
        return studentList;
    }

}
