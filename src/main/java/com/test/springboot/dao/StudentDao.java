package com.test.springboot.dao;

import com.test.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentDao extends JpaRepository<Student,Long> , JpaSpecificationExecutor<Student> {
}
