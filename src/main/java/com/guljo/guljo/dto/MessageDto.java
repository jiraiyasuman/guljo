package com.guljo.guljo.dto;

import org.antlr.v4.runtime.misc.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

public class MessageDto {

	@Schema
	@NotNull
	private String name;
	@Schema@NotNull@Email
	private String email;
	@Schema@NotNull
	private String subject;
	@Schema@NotNull
	private long mobile;
	@Schema@NotNull
	private String body;
	@Schema
	private String status;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public MessageDto(@Email String name, String email, String subject, long mobile, String body, String status) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.mobile = mobile;
		this.body = body;
		this.status = status;
	}
	public MessageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MessageDto [name=" + name + ", email=" + email + ", subject=" + subject + ", mobile=" + mobile
				+ ", body=" + body + ", status=" + status + "]";
	}
	
}
