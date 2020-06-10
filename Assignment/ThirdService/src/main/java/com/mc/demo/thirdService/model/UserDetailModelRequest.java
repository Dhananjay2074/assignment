package com.mc.demo.thirdService.model;

import javax.validation.constraints.NotNull;

public class UserDetailModelRequest {
	@NotNull(message="First name should not be blank")
	private String name;
	@NotNull(message="Second name should not be blank")
	private String surName;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}

	

}
