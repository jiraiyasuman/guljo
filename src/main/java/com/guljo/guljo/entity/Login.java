package com.guljo.guljo.entity;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name="login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	@Column(name="full_name")
	private String fullName;
	@Column(name="failed_attempt")
	private int failedAttempt;
	@Column(name="account_locked")
	private boolean accountLocked;
	@Column(name="lock_time")
	private LocalDateTime lockTime;
	@Column(name="role")
	private String role;
	@Column(name="is_active")
	private boolean isActive;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getFailedAttempt() {
		return failedAttempt;
	}
	public void setFailedAttempt(int failedAttempt) {
		this.failedAttempt = failedAttempt;
	}
	public boolean isAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	public LocalDateTime getLockTime() {
		return lockTime;
	}
	public void setLockTime(LocalDateTime lockTime) {
		this.lockTime = lockTime;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Login(int id, String email, String password, String fullName, int failedAttempt, boolean accountLocked,
			LocalDateTime lockTime, String role, boolean isActive) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.failedAttempt = failedAttempt;
		this.accountLocked = accountLocked;
		this.lockTime = lockTime;
		this.role = role;
		this.isActive = isActive;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", email=" + email + ", password=" + password + ", fullName=" + fullName
				+ ", failedAttempt=" + failedAttempt + ", accountLocked=" + accountLocked + ", lockTime=" + lockTime
				+ ", role=" + role + ", isActive=" + isActive + "]";
	}
			
}
