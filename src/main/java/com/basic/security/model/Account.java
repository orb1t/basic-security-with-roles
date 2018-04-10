package com.basic.security.model;

import java.util.Date;
import java.util.List;

public class Account {

	private String id ;
	private String userName ;
	private String password ;
	private List<String> roles ;
	private Date createdDate ;
	
	public Account(String userName , String password , List<String> roles) {
		this.userName = userName ;
		this.password = password ;
		this.roles = roles ;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", userName=" + userName + ", password=" + password + ", roles=" + roles
				+ ", createdDate=" + createdDate + "]";
	}
	
	
	
}
