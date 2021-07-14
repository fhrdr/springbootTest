package com.test.springboot;

import com.test.springboot.utils.IdWorker;
import com.test.springboot.utils.RedisUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }

    @Bean
    public RedisUtil RedisUtil(){
        return new RedisUtil();
    }
    @Bean
    public IdWorker IdWorker(){
        return new IdWorker(0,0);
    }
}
