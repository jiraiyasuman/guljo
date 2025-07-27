package com.guljo.guljo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guljo.guljo.dto.AdminAddition;
import com.guljo.guljo.dto.PasswordUpdateRequest;
import com.guljo.guljo.dto.RestrictAdmin;
import com.guljo.guljo.dto.UnlockAccount;
import com.guljo.guljo.entity.Login;
import com.guljo.guljo.repository.LoginRepository;
import com.guljo.guljo.service.LoginService;
import com.guljo.guljo.serviceimpl.LoginServiceImpl;
import com.guljo.guljo.util.StrongPasswordGenerator;

import jakarta.validation.Valid;

@Controller
@RequestMapping("api/v1")
public class LoginController {

	private LoginService loginService;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private StrongPasswordGenerator strongPasswordGenerator;
	private LoginRepository loginRepository;
	@Autowired
	public LoginController(LoginService loginService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.loginService = loginService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
	Login login = new Login();
	@PostMapping("update-password")
	public String update(@ModelAttribute @Valid PasswordUpdateRequest passwordUpdateRequest,Model model) {
	    String email = passwordUpdateRequest.getEmail();
		String password = passwordUpdateRequest.getPassword();
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		login.setEmail(email);
		login.setPassword(encodedPassword);
		login.setAccountLocked(false);
		login.setFailedAttempt(0);
		login.setLockTime(null);
		login.setRole("ADMIN_ROLE");
		login.setActive(true);
		Login updatLogin = loginService.updatePassword(login);
		return "redirect:/dashboard";
    }
	@PostMapping("add-admin")
	public String addAdmin(@ModelAttribute @Valid AdminAddition adminAddition,Model model) {
		String email = adminAddition.getEmail();
		String fullName = adminAddition.getFullName();
		String password = strongPasswordGenerator.generateStrongPassword();
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		String message ="Dear "+fullName+",<br> You have gained login access to the guljo website as an admin. Please note your login credentials.<br> Email: "+email+"<br> Password: "+password+"<br> Thanks and Regards,<br>Team Guljo";
	    login.setEmail(email);
	    login.setAccountLocked(false);
	    login.setRole("ADMIN_ROLE");
	    login.setLockTime(null);
	    login.setFullName(fullName);
	    login.setFailedAttempt(0);
	    login.setActive(true);
	    login.setPassword(encodedPassword);
	    String subject = "User Login Credentials";
	    loginServiceImpl.sendMail(login,subject, message);
	    Login savedLogin = loginService.addUser(login);
	    return "redirect:/dashboard";
	}
	@PostMapping("restrict")
	public String restrictAdmin(@ModelAttribute @Valid RestrictAdmin restrictAdmin,Model model) {
		String email = restrictAdmin.getEmail();
		boolean isActive= restrictAdmin.isActive();
		String fullName = restrictAdmin.getFullName();
		Login deletedLogin = loginRepository.findByEmail(email);
		login.setAccountLocked(deletedLogin.isAccountLocked());
		login.setFailedAttempt(deletedLogin.getFailedAttempt());
		login.setFullName(fullName);
		login.setEmail(email);
		login.setActive(isActive);
		login.setLockTime(deletedLogin.getLockTime());
		login.setPassword(deletedLogin.getPassword());
		login.setRole(deletedLogin.getRole());
		Login deleteLogin = loginService.restrictAdmin(deletedLogin);
		return "redirect:/dashboard";
	}
	@PostMapping("forgot-password")
	public String forgot(@ModelAttribute @Valid PasswordUpdateRequest passwordUpdateRequest,Model model) {
	    String email = passwordUpdateRequest.getEmail();
		String password = passwordUpdateRequest.getPassword();
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		login.setEmail(email);
		login.setPassword(encodedPassword);
		login.setAccountLocked(false);
		login.setFailedAttempt(0);
		login.setLockTime(null);
		login.setRole("ADMIN_ROLE");
		login.setActive(true);
		Login updatLogin = loginService.updatePassword(login);
		return "redirect:/login";
    }
	@PostMapping("unlock-account")
	public String unlock(@ModelAttribute @Valid UnlockAccount passwordUpdateRequest,Model model) {
	    String email = passwordUpdateRequest.getEmail();
		Login getData = loginRepository.findByEmail(email);
		login.setEmail(email);
		login.setPassword(getData.getPassword());
		login.setAccountLocked(false);
		login.setFailedAttempt(0);
		login.setLockTime(null);
		login.setRole("ADMIN_ROLE");
		login.setActive(true);
		Login updatLogin = loginService.updatePassword(login);
		return "redirect:/login";
    }
	
}