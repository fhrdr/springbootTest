package com.test.springboot.controller;

import com.test.springboot.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
public class RedisTestController {

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/set_redis")
    public void setRedis(@RequestParam("key") String key , @RequestParam("value") String value) {
        if (redisUtil.hasKey(key)){
            redisUtil.set(key,value);
            System.out.println("更新成功！ ==> {"+key+":"+value+"}");
        }
        redisUtil.set(key,value);
        System.out.println("添加成功！ ==> {"+key+":"+value+"}");
    }

    @GetMapping("/get_redis")
    public String getRedis(@RequestParam String key){
        if (redisUtil.hasKey(key)){
            String value = (String) redisUtil.get(key);
            System.out.println("{"+key+":"+value+"}");
            return "{"+key+":"+value+"}";
        }
        return "不存在"+key;
    }

    @GetMapping("/delete_redis")
    public String deleteRedis(@RequestParam String key){
        if (redisUtil.hasKey(key)){
            redisUtil.del(key);
            System.out.println("删除 " + key + " 成功！");
            return "删除 " + key + " 成功！";
        }
        return "不存在"+key;
    }
}
