package com.test.springboot.controller;

import com.test.springboot.dao.*;
import com.test.springboot.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TablesController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private GroupDao groupDao;
    @Autowired
    private InfoDao infoDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private TeacherDao teacherDao;

    // 一对多关系

    @GetMapping("/get_all_groups")
    public List<Group> getAllGroups(){
        return groupDao.findAll();
    }

    // 多对一关系
    @GetMapping("/get_all_users")
    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    // 一对一关系
    @GetMapping("/get_one_to_one")
    public List<Info> getOneToOne(){
        return infoDao.findAll();
    }

    // 多对多关系
    @GetMapping("/get_teacher_student")
    public List<Student> getTeacherStudent(){
        return studentDao.findAll();
    }

    // 自定义查询
    @GetMapping("/get_all_userGroups")
    public List<UserGroup> getAllUserGroups(){
        // 查询数据
        List<Object[]> test = userDao.findAll1();
        // 创建相关类用来存储
        List<UserGroup> userGroupList = new ArrayList<>();
        // 相应的赋值
        for (Object[] o : test){
            userGroupList.add(new UserGroup(o[0],o[1],o[2]));
        }
        // 打印返回结果
        System.out.println(userGroupList);
        return userGroupList;
    }
}
