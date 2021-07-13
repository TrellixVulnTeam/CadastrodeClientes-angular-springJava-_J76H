package br.com.springboot.controller;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users") // http://localhost:8081/users


public class UserController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

}