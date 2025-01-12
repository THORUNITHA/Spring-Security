package com.security.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> studentsList = new ArrayList<>(List.of( new Student(1,"Thoru","Computer"),
            new Student(2,"Vk","Maths")));
    @RequestMapping("/students")
    public List<Student> getAllStudents(){
        return studentsList;
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student){
        studentsList.add(student);
        return student;
    }
// Post Request is not working without CSRF -- Cross Site Request Forgery

}