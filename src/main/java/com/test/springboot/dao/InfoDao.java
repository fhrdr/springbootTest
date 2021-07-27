package com.test.springboot.dao;

import com.test.springboot.entity.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InfoDao extends JpaRepository<Info,Long> , JpaSpecificationExecutor<Info> {
}
