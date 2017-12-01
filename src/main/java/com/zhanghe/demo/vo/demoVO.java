package com.zhanghe.demo.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class demoVO {
	@NotNull
	public String name;
	@Length(min=5,max=16)
	public String password;
	
	public String getName() {
		return name;
	}
	public void setName( String name ) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword( String password ) {
		this.password = password;
	}
	
	
}
