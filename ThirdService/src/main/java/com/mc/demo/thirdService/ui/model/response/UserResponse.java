package com.mc.demo.thirdService.ui.model.response;

import com.mc.demo.thirdService.service.dto.UserDesignation;

public class UserResponse {

	private UserDesignation[] userDesignation;

	public UserDesignation[] getUserDesignation() {
		return userDesignation;
	}

	public void setUserDesignation(UserDesignation[] userDesignation) {
		this.userDesignation = userDesignation;
	}
	
}
