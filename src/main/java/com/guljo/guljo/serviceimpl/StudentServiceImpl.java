package com.guljo.guljo.serviceimpl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.validator.internal.util.privilegedactions.GetClassLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.guljo.guljo.entity.Student;
import com.guljo.guljo.exception.NotFoundException;
import com.guljo.guljo.repository.StudentRepository;
import com.guljo.guljo.service.StudentService;

import jakarta.transaction.Transactional;
@Service
public class StudentServiceImpl  implements StudentService{

	private final Logger LOGGER = Logger.getLogger(getClass().getName());
	private StudentRepository studentRepository;
	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Transactional
	@Override
	public Student addStudent(Student student) {
		Student saveStudent = studentRepository.save(student);
		LOGGER.info("Student insertion is done successfully");
		return saveStudent;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> getAll = studentRepository.findAll();
		LOGGER.info("Get all students is done successfully");
		return getAll;
	}

	@Override
	public Student getStudentById(int id) {
		Student student = studentRepository.findById(id).get();
		if(student== null) {
			LOGGER.warning("Student details are not found");
			throw new NotFoundException(" Student details Not found ");
		}
		LOGGER.info("Student details by id executed successfully");
		return student;
	}

	@Override
	public Page<Student> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
			Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo-1, pageSize,sort);
		return this.studentRepository.findAll(pageable);
	}
	
}
