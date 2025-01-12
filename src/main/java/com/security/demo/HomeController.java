package com.security.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String greet(){
        return "Hello World";
    }

    //CSRF - Cross site request Forgery
    // OWASP - open web application security project
}
