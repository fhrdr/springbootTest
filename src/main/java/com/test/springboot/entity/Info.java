package com.test.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_info")
public class Info {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name" )
	private String name;
	@Column(name = "phone" )
	private String phone;
	@Column(name = "sex" )
	private String sex;
	@Column(name = "age" )
	private long age;
	@Column(name = "create_time" )
	private Date createTime;
	@JsonIgnoreProperties({"info","group"})
    @OneToOne(mappedBy = "info")
    private User user;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
