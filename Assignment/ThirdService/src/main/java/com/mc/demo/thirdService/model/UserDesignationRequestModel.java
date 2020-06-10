package com.mc.demo.thirdService.model;

import com.mc.demo.thirdService.service.dto.UserDesignation;

public class UserDesignationRequestModel {
	
	private UserDesignation[] userDesignations;

	public UserDesignation[] getUserDesignations() {
		return userDesignations;
	}

	public void setUserDesignations(UserDesignation[] userDesignations) {
		this.userDesignations = userDesignations;
	}
	

}
