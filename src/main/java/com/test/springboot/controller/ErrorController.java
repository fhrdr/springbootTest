package com.test.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
    @GetMapping("/403")
    public String page403() {
        return "返回错误页面！";
    }
}
