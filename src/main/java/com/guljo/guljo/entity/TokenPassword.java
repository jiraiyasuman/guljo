package com.guljo.guljo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name="token_password")
public class TokenPassword {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="token")
	private String token;
	@Column(name="local_date_time")
	private LocalDateTime expiryDateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LocalDateTime getExpiryDateTime() {
		return expiryDateTime;
	}
	public void setExpiryDateTime(LocalDateTime expiryDateTime) {
		this.expiryDateTime = expiryDateTime;
	}
	public TokenPassword(int id, String token, LocalDateTime expiryDateTime) {
		super();
		this.id = id;
		this.token = token;
		this.expiryDateTime = expiryDateTime;
	}
	public TokenPassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TokenPassword [id=" + id + ", token=" + token + ", expiryDateTime=" + expiryDateTime + "]";
	}
	
}
