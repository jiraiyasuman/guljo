package com.guljo.guljo.dto;

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;

public class StudentSto {

	@Schema
	@NotNull
	private String name;
	@Schema@Email@NotNull
	private String email;
	@NotNull@Schema
	private String address;
	@NotNull@Schema
	private String fatherName;
	@Schema@NotNull
	private LocalDate dob;
	@NotNull@Schema
	private String occupation;
	@Schema@NotNull
	private String workStatus;
	@NotNull@Schema
	private long mobile;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getWorkStatus() {
		return workStatus;
	}
	public void setWorkStatus(String workStatus) {
		this.workStatus = workStatus;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public StudentSto(String name, @Email String email, String address, String fatherName, LocalDate dob,
			String occupation, String workStatus, long mobile) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.fatherName = fatherName;
		this.dob = dob;
		this.occupation = occupation;
		this.workStatus = workStatus;
		this.mobile = mobile;
	}
	public StudentSto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StudentSto [name=" + name + ", email=" + email + ", address=" + address + ", fatherName=" + fatherName
				+ ", dob=" + dob + ", occupation=" + occupation + ", workStatus=" + workStatus + ", mobile=" + mobile
				+ "]";
	}
	
	
}
