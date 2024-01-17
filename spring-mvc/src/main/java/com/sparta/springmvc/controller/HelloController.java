package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class HelloController {

//    @GetMapping("/api/hello")
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

//    @GetMapping("/api/get")
    @GetMapping("/get")
    @ResponseBody
    public String get() {
        return "request GET Method";
    }

//    @PostMapping("/api/post")
    @PostMapping("/post")
    @ResponseBody
    public String post() {
        return "request POST Method";
    }

//    @PutMapping("/api/put")
    @PutMapping("/put")
    @ResponseBody
    public String put() {
        return "request PUT Method";
    }

//    @DeleteMapping("/api/delete")
    @DeleteMapping("/delete")
    @ResponseBody
    public String delete() {
        return "request DELETE Method";
    }
}
