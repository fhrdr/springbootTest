package com.test.springboot.controller;

import com.test.springboot.utils.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IdWorkerController {
    // 注入
    @Autowired
    private IdWorker idWorker;

    @GetMapping("/get_new_id")
    public long getNewId(){
        return idWorker.nextId();
    }
}
