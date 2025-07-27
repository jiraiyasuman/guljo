package com.guljo.guljo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.guljo.guljo.dto.CoursesDto;
import com.guljo.guljo.entity.Courses;
import com.guljo.guljo.service.CoursesService;
import com.guljo.guljo.serviceimpl.CoursesServicesImpl;

import jakarta.validation.Valid;

@Controller
@RequestMapping("api/v1")
public class CoursesController {

	private CoursesService coursesService;
	private CoursesServicesImpl coursesServicesImpl;
	@Autowired
	public CoursesController(CoursesService coursesService) {
		super();
		this.coursesService = coursesService;
	}
	Courses courses = new Courses();
	@PostMapping("save-courses")
	public String addCourses(@ModelAttribute @Valid CoursesDto coursesDto,Model model) {
		courses.setName(coursesDto.getName());
		courses.setLocalDateTime(LocalDateTime.now());
		courses.setFatherName(coursesDto.getFatherName());
		courses.setOccupation(coursesDto.getOccupation());
		courses.setCourseName(coursesDto.getCourseName());
		Courses savedCourses = coursesService.addCourses(courses);
		return "redirect:/index";
	}
	
	@GetMapping("display-courses")
	public String viewHomePage(Model model) {
		return findPaginated(1, "name", "asc", model);		
	}
	@GetMapping("display-courses/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<Courses> page = coursesServicesImpl.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<Courses> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listCourses", listEmployees);
		return "display-courses";
	}
	
}
