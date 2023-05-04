package ru.sorokin.clientintegration1c.controllers.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/hello")
    public String hello(@RequestParam(required = false) String name) {
        System.out.println("Hello, " + name);
        return "Hello, " + name;
    }
}
