package com.zhanghe.demo.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class InsertUserVO {
	
	@NotNull
	@Length(min=5,max=16)
	String userName;
	@NotNull
	@Length(min=5,max=16)
	String name;
	@NotNull
	Integer status;
	@NotNull
	@Length(min=5,max=16)
	String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName( String userName ) {
		this.userName = userName;
	}
	public String getName() {
		return name;
	}
	public void setName( String name ) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus( Integer status ) {
		this.status = status;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword( String password ) {
		this.password = password;
	}
	
}
