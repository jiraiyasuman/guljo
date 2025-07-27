package com.guljo.guljo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guljo.guljo.dto.StudentSto;
import com.guljo.guljo.entity.Student;
import com.guljo.guljo.mapper.StudentAutoMapper;
import com.guljo.guljo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

	private StudentService studentService;

	private final Logger LOGGER = Logger.getLogger(getClass().getName());
	StudentAutoMapper studentAutoMapper = new StudentAutoMapper();
	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	@PostMapping("save")
	public ResponseEntity<StudentSto> saveStudent(@Valid @RequestBody StudentSto studentSto){
		Student student = studentAutoMapper.mapToStudent(studentSto);
		Student savedStudent = studentService.addStudent(student);
		StudentSto savedStudentSto = studentAutoMapper.mapToStudentSto(savedStudent);
		LOGGER.info("Save Student controller is executed successfully");
		return ResponseEntity.ok(savedStudentSto);
	}
	@GetMapping("list")
	public ResponseEntity<Map<String,Object>> getAll(){
		return findPaginated(1,"name","asc");
	}
	@GetMapping("list/page/{pageNumber}")
	public ResponseEntity<Map<String,Object>> findPaginated(
			@PathVariable("pageNumber") int pageNo,
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir
			){
		int pageSize = 10;
		Page<Student> page = studentService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Student> listStudents = page.getContent();
		
		Map<String,Object> response =  new HashMap<>();
		
		response.put("currentPage", pageNo);
		response.put("totalElements", page.getTotalElements());
		response.put("totalPages", page.getTotalPages());
		response.put("sortField", sortField);
		response.put("sortDir", sortDir);
		response.put("reverseSortDir", sortDir.equals("asc")?"desc":"asc");
		response.put("listStudents", listStudents);
		return ResponseEntity.ok(response);
	}
	@GetMapping("list/{id}")
	public ResponseEntity<StudentSto> getStudentById(@PathVariable("id") int id){
		Student student =studentService.getStudentById(id);
		StudentSto studentSto = studentAutoMapper.mapToStudentSto(student);
		return ResponseEntity.ok(studentSto);
	}
	
}
