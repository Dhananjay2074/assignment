package com.mc.demo.thirdService.service.dto;

public class UserDesignation {

	private String occupation;
	private UserDesignationType[] type;

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public UserDesignationType[] getType() {
		return type;
	}

	public void setType(UserDesignationType[] type) {
		this.type = type;
	}

}
