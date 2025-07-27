package com.guljo.guljo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.guljo.guljo.entity.Courses;
import com.guljo.guljo.repository.CourseRepository;
import com.guljo.guljo.service.CoursesService;

@Service
public class CoursesServicesImpl implements CoursesService{

	private CourseRepository courseRepository;
	@Autowired
	public CoursesServicesImpl(CourseRepository courseRepository) {
		super();
		this.courseRepository = courseRepository;
	}

	@Override
	public Courses addCourses(Courses courses) {
		Courses savedCourses = courseRepository.save(courses);
		return savedCourses;
	}

	@Override
	public List<Courses> getAll() {
		List<Courses> find= courseRepository.findAll();
		return find;
	}
	public Page<Courses> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending():
			Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo-1, pageSize,sort);
		return this.courseRepository.findAll(pageable);
	}

}
