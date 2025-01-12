package com.security.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getToken")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}