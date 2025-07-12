package com.guljo.guljo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.guljo.guljo.entity.Student;

public interface StudentService {

	public Student addStudent(Student student);
	public List<Student> getAllStudents();
	
	public Student getStudentById(int id);
	public Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	
}
