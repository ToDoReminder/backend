package com.example.todoreminder.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/")
@RestController
public class DemoController {
    @GetMapping
    public String helloWorld(){

        return "Hello World!";
    }
}
