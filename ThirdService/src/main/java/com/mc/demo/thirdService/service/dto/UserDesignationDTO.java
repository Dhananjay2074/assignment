package com.mc.demo.thirdService.service.dto;

import java.io.Serializable;

public class UserDesignationDTO implements Serializable{

	private static final long serialVersionUID = 3301486852190784532L;
	private UserDesignation[] userDesignation;

	public UserDesignation[] getUserDesignation() {
		return userDesignation;
	}

	public void setUserDesignation(UserDesignation[] userDesignation) {
		this.userDesignation = userDesignation;
	}
	
}
