package com.test.springboot.dao;

import com.test.springboot.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GroupDao extends JpaRepository<Group,Long> , JpaSpecificationExecutor<Group> {
}
