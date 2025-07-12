package com.guljo.guljo.dto;

import org.antlr.v4.runtime.misc.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

public class LoginDto {

	@Schema@Email@NotNull
	private String email;
	@Schema@NotNull
	private String name;
	@Schema@NotNull
	private String password;
	@Schema@NotNull
	private long mobile;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public LoginDto(@Email String email, String name, String password, long mobile) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
	}
	public LoginDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
