package com.guljo.guljo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guljo.guljo.config.CustomUserDetails;
import com.guljo.guljo.dto.AdminAddition;
import com.guljo.guljo.dto.ForgotPassword;
import com.guljo.guljo.dto.UnlockAccount;
import com.guljo.guljo.entity.Courses;
import com.guljo.guljo.entity.Login;
//import com.guljo.guljo.entity.Login;
import com.guljo.guljo.entity.Message;
import com.guljo.guljo.repository.LoginRepository;
import com.guljo.guljo.serviceimpl.LoginServiceImpl;

@Controller
@RequestMapping("api/v1")
public class HomeController {

	private LoginRepository loginRepository;
	private LoginServiceImpl loginServiceImpl;
	@Autowired
	public HomeController(LoginRepository loginRepository, LoginServiceImpl loginServiceImpl) {
		super();
		this.loginRepository = loginRepository;
		this.loginServiceImpl = loginServiceImpl;
	}
	@GetMapping("home")
	public String home() {
		return "index";
	}
	@GetMapping("about")
	public String about() {
		return "about";
	}
	@GetMapping("service")
	public String services() {
		return "services";
	}
	@GetMapping("contact")
	public String contact(Model model) {
		model.addAttribute("Message", new Message());
		return "contact";
	}
	@GetMapping("login")
	public String login(Model model) {
		model.addAttribute("Login",new Login());
		return "login";
	}
	@GetMapping("dashboard")
	public String dashboard(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        model.addAttribute("name", userDetails.getFullName());
        model.addAttribute("email", userDetails.getEmail());
        model.addAttribute("role", userDetails.getRole());
        return "dashboard";
    }
	@GetMapping("profile")
	public String profile(@AuthenticationPrincipal CustomUserDetails customUserDetails,Model model) {
		model.addAttribute("name",customUserDetails.getFullName());
		model.addAttribute("email",customUserDetails.getEmail());
		model.addAttribute("role",customUserDetails.getRole());
		return "profile";
	}
	@GetMapping("settings")
	public String settings(@AuthenticationPrincipal CustomUserDetails customUserDetails,Model model) {
		model.addAttribute("email",customUserDetails.getEmail());
		return "settings";
	}
	@GetMapping("add")
	public String openAddAdmin(Model model) {
		model.addAttribute("Admin-Addition",new AdminAddition());
		return "add-admin";
	}
	@GetMapping("courses-add")
	public String addCourses(Model model) {
		model.addAttribute("Courses",new Courses());
		return "courses-add";
	}
	@GetMapping("display-messages")
	public String displayMessages() {
		return "display-messages";
	}
	@GetMapping("forgot")
	public String forgot(Model model) {
		model.addAttribute("Forgot",new ForgotPassword());
		return "forgot";
	}
	@GetMapping("unlock")
	public String unlock(Model model) {
		model.addAttribute("Unlock",new UnlockAccount());
		return "unlock";
	}
	@PostMapping("forgotPassword")
	public String forgotPassword(@ModelAttribute ForgotPassword forgotPassword) {
		String output = "";
		Login user = loginRepository.findByEmail(forgotPassword.getEmail());
		if (user != null) {
			output = loginServiceImpl.sendEmail(user);
		}
		if (output.equals("success")) {
			return "redirect:/success";
		}
		return "redirect:/login";
	}
	
	public String success() {
		return "success";
	}
}
