package com.guljo.guljo.dto;

import org.antlr.v4.runtime.misc.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

public class PasswordUpdateRequest {

	@Email@Schema@NotNull
	private String email;
	@Schema@NotNull
	private String password;
	@Schema@NotNull
	private String confirmPassword;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public PasswordUpdateRequest(@Email String email, String password, String confirmPassword) {
		super();
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}
	public PasswordUpdateRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PasswordUpdateRequest [email=" + email + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}
		
}
