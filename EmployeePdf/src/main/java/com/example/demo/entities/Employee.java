package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="Employee_name")
	private String name;
	@Column(name="Email_id")
	private String email;
	@Column(name="Mobile_Number")
	private String mobileNo;
	
	@CreationTimestamp
	private Date time_date;
	
	@UpdateTimestamp
	private Date date;
	
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
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Employee(int id, String name, String email, String mobileNo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
	}
	public Employee() {
		super();
	}
	
	
	
}
