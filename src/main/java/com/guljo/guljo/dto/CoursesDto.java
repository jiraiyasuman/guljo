package com.guljo.guljo.dto;

import org.antlr.v4.runtime.misc.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;

public class CoursesDto {

	
	@Schema@NotNull
	private String name;
	@NotNull@Schema
	private String fatherName;
	@Schema@NotNull
	private String occupation;
	@Schema@NotNull
	private String courseName;
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
	public CoursesDto(String name, String fatherName, String occupation, String courseName) {
		super();
		this.name = name;
		this.fatherName = fatherName;
		this.occupation = occupation;
		this.courseName = courseName;
	}
	public CoursesDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CoursesDto [name=" + name + ", fatherName=" + fatherName + ", occupation=" + occupation
				+ ", courseName=" + courseName + "]";
	}
	
}
