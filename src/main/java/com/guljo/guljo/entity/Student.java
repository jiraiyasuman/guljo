package com.guljo.guljo.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="email")
	private String email;
	@Column(name="address")
	private String address;
	@Column(name="father_name")
	private String fatherName;
	@Column(name="occupation")
	private String occupation;
	@Column(name="dob")
	private LocalDate dob;
	@Column(name="work_status")
	private String workStatus;
	@Column(name="mobile")
	private long mobile;
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
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
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
	public Student(int id, String name, String email, String address, String fatherName, String occupation,
			LocalDate dob, String workStatus, long mobile) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.fatherName = fatherName;
		this.occupation = occupation;
		this.dob = dob;
		this.workStatus = workStatus;
		this.mobile = mobile;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", fatherName="
				+ fatherName + ", occupation=" + occupation + ", dob=" + dob + ", workStatus=" + workStatus
				+ ", mobile=" + mobile + "]";
	}
	
}
