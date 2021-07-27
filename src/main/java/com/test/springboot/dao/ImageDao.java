package com.test.springboot.dao;

import com.test.springboot.entity.Image;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

public interface ImageDao extends JpaRepository<Image,Long>, JpaSpecificationExecutor<Image> {
}
