package com.guljo.guljo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
@Entity(name="message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="subject")
	private String subject;
	@Column(name="email")
	private String email;
	@Column(name="mobile")
	private long mobile;
	@Column(name="body")
	private String body;
	@Column(name="status")
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Message(int id, String name, String subject, String email, long mobile, String body, String status) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.email = email;
		this.mobile = mobile;
		this.body = body;
		this.status = status;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + ", subject=" + subject + ", email=" + email + ", mobile="
				+ mobile + ", body=" + body + ", status=" + status + "]";
	}
	
}
