package com.capgemini.onlinetest.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="userr")
public class Userdata {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int userid;
	@Column(length=20)
	private String username;
	
	@OneToOne(targetEntity=Test.class,cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="testid", referencedColumnName="testId") 
	private Test usertest;
	@Size(min=3, max=20, message="password must be minimum 8 characters")
	private String userPassword;
	@Min(value=4)
	private long userPhoneno;
	@Email(message="enter proper email id")
	private String userEmail;
	@NotBlank(message="usertype cannot be empty")
	private String userType;
	
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	//@JsonIgnore
	public Test getUsertest() {
		return usertest;
	}
	public void setUsertest(Test usertest) {
		this.usertest = usertest;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public long getUserPhoneno() {
		return userPhoneno;
	}
	public void setUserPhoneno(long userPhoneno) {
		this.userPhoneno = userPhoneno;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
}









/*

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(name = "Userdata_otm")
public class Userdata {
	@Id
	private int userId;
	@NotBlank(message="username cannot be empty")
	private String userName;
	@NotBlank(message="usertype cannot be empty")
	@OneToOne(cascade=CascadeType.ALL, fetch =FetchType.EAGER)
	@JoinColumn(name="t_id")
	private Test userType;
	@Size(min=3, max=20, message="password must be minimum 8 characters")
	private String userPassword;
	@Min(value=4)
	private long userPhoneno;
	@Email(message="enter proper email id")
	private String userEmail;

	public Userdata() {
		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Test getUserType() {
		return userType;
	}
	public void setUserType(Test userType) {
		this.userType = userType;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public long getUserPhoneno() {
		return userPhoneno;
	}
	public void setUserPhoneno(long userPhoneno) {
		this.userPhoneno = userPhoneno;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	

	
}*/