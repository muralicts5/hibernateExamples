package com.examples.hibernateexamples.association.manytomany;


import java.util.*;
import javax.persistence.*;

@Entity
public class Student {
	private String studentName;
	@Id
	private int studentId;
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public Student() {
	}
	@ManyToMany(
			cascade = {CascadeType.ALL},
			mappedBy = "Students",
			targetEntity = Course.class
			)
	private Set<Course> courses=new HashSet<Course>();
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}


