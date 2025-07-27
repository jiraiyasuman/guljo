package com.guljo.guljo.dto;

import org.antlr.v4.runtime.misc.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

public class UnlockAccount {
	@Schema@NotNull@Email
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UnlockAccount(@Email String email) {
		super();
		this.email = email;
	}

	public UnlockAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UnlockAccount [email=" + email + "]";
	}
	

}
