package com.guljo.guljo.mapper;

import com.guljo.guljo.dto.StudentSto;
import com.guljo.guljo.entity.Student;

public class StudentAutoMapper {

	
	Student student = new Student();
	StudentSto studentSto = new StudentSto();
	public Student mapToStudent(StudentSto studentSto) {
		student.setName(studentSto.getName());
		student.setAddress(studentSto.getAddress());
		student.setEmail(studentSto.getEmail());
		student.setDob(studentSto.getDob());
		student.setFatherName(studentSto.getFatherName());
		student.setMobile(studentSto.getMobile());
		student.setOccupation(studentSto.getOccupation());
		student.setWorkStatus(studentSto.getWorkStatus());
		return student;
	}
	
	public StudentSto mapToStudentSto(Student student) {
		studentSto.setName(student.getName());
		studentSto.setAddress(student.getAddress());
		studentSto.setEmail(student.getEmail());
		studentSto.setDob(student.getDob());
		studentSto.setFatherName(student.getFatherName());
		studentSto.setMobile(student.getMobile());
		studentSto.setOccupation(student.getOccupation());
		studentSto.setWorkStatus(student.getWorkStatus());
		return studentSto;
		
	}
}
