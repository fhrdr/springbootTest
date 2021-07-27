package com.test.springboot.controller;

import com.test.springboot.utils.EmailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MailController {

    @GetMapping("/send_email_code")
    @Async
    public void sendEmailVerifyCode(String emailAddress) throws Exception {
        Random random = new Random();
        int verifyCode = random.nextInt(999999);
        if (verifyCode < 100000) {
            verifyCode += 100000;
        }
        EmailSender.sendRegisterVerifyCode(verifyCode, emailAddress);
        System.out.println("邮箱发送成功！ ==> "+verifyCode);
    }
}
