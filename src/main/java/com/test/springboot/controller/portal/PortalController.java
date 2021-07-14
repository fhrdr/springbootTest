package com.test.springboot.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/portal")
public class PortalController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello portal!!!";
    }
}
