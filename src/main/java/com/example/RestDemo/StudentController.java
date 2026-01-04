package com.example.RestDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    @RequestMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @RequestMapping("/addStudent")
    public String addStudent() {
        Student student = new Student();
        student.setName("John Doe");
        student.setAge(20);
        studentRepo.save(student);
        return "Student added: " + student.toString();
    }
}
