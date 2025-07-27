package com.guljo.guljo.dto;

import org.antlr.v4.runtime.misc.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

public class AdminAddition {

	@Schema
	@Email@NotNull
	private String email;
	@Schema@NotNull
	private String fullName;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public AdminAddition(@Email String email, String fullName) {
		super();
		this.email = email;
		this.fullName = fullName;
	}
	public AdminAddition() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdminAddition [email=" + email + ", fullName=" + fullName + "]";
	}
	
		
}
