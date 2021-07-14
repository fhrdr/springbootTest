package com.test.springboot.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class encryptController {

    @GetMapping("/encrypt_password")
    public void encryptPassword(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        // 加密后的密码（以下三个为123456加密的样子，拿任意一个使用matches进行对比都可以）
        /*
        $2a$10$YC5J9Y/2dByp0jHnupD7SOhzDGPppOvZrstG.5Eoi0HAyM30CW7TC
        $2a$10$NHH85xyVm6WKsv2ykFd7yOYXmbqUX4Uda0t0W9poNWF7G.30cfN.a
        $2a$10$oilNr29D1TeVcRfJ1WpwiO6BpTTNVpxIp7UffX0dZRx5iQGylD8wa
         */

        // 登录验证:123456
        boolean result = passwordEncoder.matches("123456",
                "$2a$10$oilNr29D1TeVcRfJ1WpwiO6BpTTNVpxIp7UffX0dZRx5iQGylD8wa");
        System.out.println("result ==> "+result);
    }
}
