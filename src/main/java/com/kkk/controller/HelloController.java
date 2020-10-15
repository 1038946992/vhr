package com.kkk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/employee/basic/hello2")
    public String hello2(){
        return "/employee/basic/hello2";
    }

    @GetMapping("/employee/advanced/hello3")
    public String hello3(){
        return "/employee/advanced/hello3";
    }
}
