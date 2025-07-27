package com.guljo.guljo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.guljo.guljo.entity.AnalyticsData;
import com.guljo.guljo.entity.Courses;
import com.guljo.guljo.serviceimpl.AnalyticsDataServiceImpl;

@Controller
@RequestMapping("api/v1")
public class AnalyticsDataController {

	private AnalyticsDataServiceImpl analyticsDataServiceImpl;
	@Autowired
	public AnalyticsDataController(AnalyticsDataServiceImpl analyticsDataServiceImpl) {
		super();
		this.analyticsDataServiceImpl = analyticsDataServiceImpl;
	}
	@GetMapping("display-data")
	public String viewHomePage(Model model) {
		return findPaginated(1, "userAgent", "asc", model);		
	}
	@GetMapping("display-data/page/{pageNumber}")
	public String findPaginated(@PathVariable (value = "pageNumber") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<AnalyticsData> page = analyticsDataServiceImpl.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<AnalyticsData> listEmployees = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listCourses", listEmployees);
		return "display-data";
	}
}
