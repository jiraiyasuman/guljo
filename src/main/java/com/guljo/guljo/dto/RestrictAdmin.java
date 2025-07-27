package com.guljo.guljo.dto;

import org.antlr.v4.runtime.misc.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;

public class RestrictAdmin {

	@Email@Schema@NotNull
	private String email;
	@Schema
	private boolean isActive;
	@Schema@NotNull
	private String fullName;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public RestrictAdmin(@Email String email, boolean isActive, String fullName) {
		super();
		this.email = email;
		this.isActive = isActive;
		this.fullName = fullName;
	}
	public RestrictAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "RestrictAdmin [email=" + email + ", isActive=" + isActive + ", fullName=" + fullName + "]";
	}
	
	
}
