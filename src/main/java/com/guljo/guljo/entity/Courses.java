 package com.guljo.guljo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name="courses")
public class Courses {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="father_name")
	private String fatherName;
	@Column(name="occupation")
	private String occupation;
	@Column(name="course_name")
	private String courseName;
	@Column(name="local_date_time")
	private LocalDateTime localDateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}
	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}
	public Courses(int id, String name, String fatherName, String occupation, String courseName,
			LocalDateTime localDateTime) {
		super();
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.occupation = occupation;
		this.courseName = courseName;
		this.localDateTime = localDateTime;
	}
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Courses [id=" + id + ", name=" + name + ", fatherName=" + fatherName + ", occupation=" + occupation
				+ ", courseName=" + courseName + ", localDateTime=" + localDateTime + "]";
	}
}
