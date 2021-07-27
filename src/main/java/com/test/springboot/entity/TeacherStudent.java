package com.test.springboot.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_teacher_student")
public class TeacherStudent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "teacher_id" )
	private long teacherId;
	@Column(name = "student_id" )
	private long studentId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getTeacherId() {
    return teacherId;
  }

  public void setTeacherId(long teacherId) {
    this.teacherId = teacherId;
  }


  public long getStudentId() {
    return studentId;
  }

  public void setStudentId(long studentId) {
    this.studentId = studentId;
  }

}
