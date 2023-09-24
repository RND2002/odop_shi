package com.odopBackend.odopShi_RestApi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/public/hello")
    public String helloController(){
        return "Hello Biaaatch";
    }

    @GetMapping("safe")
    public String safeController(){
        return "This is accessed by admin";
    }
}
