package com.test.springboot.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "test",name = "t_image")
public class Image {

  @Id
  private String id;
  @Column(name = "name")
  private String name;
  @Column(name = "size")
  private String size;
  @Column(name = "type")
  private String type;
  @Column(name = "path")
  private String path;
  @Column(name = "create_time")
  private Date createTime;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }
}
