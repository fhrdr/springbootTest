package com.test.springboot.dao;

import com.test.springboot.entity.Group;
import com.test.springboot.entity.User;
import com.test.springboot.entity.UserGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User,Long> , JpaSpecificationExecutor<User> {

    @Query(value = "SELECT u.name,u.passwd,g.name group_name FROM t_user as u , t_group as g where u.group_id=g.id" , nativeQuery = true)
    List<Object[]> findAll1();
}
