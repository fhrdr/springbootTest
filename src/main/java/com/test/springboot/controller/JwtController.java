package com.test.springboot.controller;

import com.test.springboot.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class JwtController {

    // 生成token
    @GetMapping("/create_token")
    public String createToken(String id, String username, String mail){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", id);
        claims.put("userName", username);
        claims.put("email", mail);
        String token = JwtUtils.createToken(claims);//有效期为1分钟
        System.out.println("token ==> "+token);
        return "token ==> "+token;
    }

    // 解析token
    @GetMapping("/parse_token")
    public String parseToken(String token){
        Claims claim = JwtUtils.parseJWT(token);
        Object id = claim.get("id");
        Object username = claim.get("userName");
        Object email = claim.get("email");
        System.out.println("{id:"+id+"," + "userName:"+username+"," + "email:"+email+"}");
        return "{id:"+id+"," + "userName:"+username+"," + "email:"+email+"}";
    }
}
