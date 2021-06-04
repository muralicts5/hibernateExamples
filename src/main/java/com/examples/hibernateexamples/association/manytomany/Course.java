package com.examples.hibernateexamples.association.manytomany;

import java.util.*;
import javax.persistence.*;

@Entity
public class Course {
	@Id
	private int courseCode;
	private String courseName;
	private String subject;
	public Course() {
		super();
	}
	@ManyToMany(
			cascade={CascadeType.ALL}
			)

	@JoinTable(
			name="Enrollment",
			joinColumns=@JoinColumn(name="course_Code"),
			inverseJoinColumns=@JoinColumn(name="student_Id")
			)
	private Set<Student>  Students=new HashSet<Student>();
	public Set<Student> getStudents() {
		return Students;
	}

	public void setStudents(Set<Student> students) {
		Students = students;
	}

	public int getCouseCode() {
		return courseCode;
	}

	public void setCouseCode(int couseCode) {
		this.courseCode = couseCode;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
