package com.security.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String greet(HttpServletRequest request){
        return "Hello World" + " " + request.getSession().getId();
    }

    //CSRF - Cross site request Forgery
    // OWASP - open web application security project
    //Security filter chain - By default we will have filters like login, session and csrf token
    //create your own security filter chain (Customize)
}
