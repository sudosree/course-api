package com.example.courseapi.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/test")
    public String test() {
        return "Hello World!!!";
    }

    @GetMapping("/greetings")
    public String greetings() {
        return "Greetings from Spring Boot!";
    }
}
