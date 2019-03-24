package com.firewood.springbootdatajpa.service;

import com.firewood.springbootdatajpa.model.School;
import com.firewood.springbootdatajpa.model.Student;
import com.firewood.springbootdatajpa.repository.SchoolRepository;
import com.firewood.springbootdatajpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    private final StudentRepository studentRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository, StudentRepository studentRepository) {
        this.schoolRepository = schoolRepository;
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void addSchoolToStudent() {
        School school = new School("신촌초등학교");
        schoolRepository.save(school);

        Student student1 = new Student("서준");
        Student student2 = new Student("서연");
        Student student3 = new Student("서언");

        student1.setSchool(school);
        student2.setSchool(school);
        student3.setSchool(school);

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        List<Student> all = studentRepository.findAll();

        for (Student s : all) {
            System.out.println(s.toString());
        }
    }

    @Transactional
    public void addStudentsToSchool() {
        Student student1 = new Student("고길동");
        Student student2 = new Student("김연아");
        studentRepository.save(student1);
        studentRepository.save(student2);

        Student student3 = new Student("박찬호");
        Student student4 = new Student("손흥민");
        studentRepository.save(student3);
        studentRepository.save(student4);

        School school1 = new School("한국 고등학교");
        school1.setStudents(Arrays.asList(student1, student2));

        School school2 = new School("국제 고등학교");
        school2.setStudents(Arrays.asList(student3, student4));

        schoolRepository.save(school1);
        schoolRepository.save(school2);

        List<School> schools = schoolRepository.findAll();

        for(School s : schools) {
            System.out.println(s.toString());
        }
    }

}
