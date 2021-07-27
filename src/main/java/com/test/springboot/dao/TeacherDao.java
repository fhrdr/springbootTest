package com.test.springboot.dao;

import com.test.springboot.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherDao extends JpaRepository<Teacher,Long> , JpaSpecificationExecutor<Teacher> {
}
