package com.guljo.guljo.service;

import java.util.List;

import com.guljo.guljo.entity.Courses;

public interface CoursesService {

	public Courses addCourses(Courses courses);
	
	public List<Courses> getAll();
}
