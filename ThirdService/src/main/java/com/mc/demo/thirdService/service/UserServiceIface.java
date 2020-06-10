package com.mc.demo.thirdService.service;


import java.util.List;

import com.mc.demo.thirdService.service.dto.UserDesignation;
import com.mc.demo.thirdService.service.dto.UserDesignationDTO;

public interface UserServiceIface  {
	
	UserDesignationDTO save(UserDesignationDTO userDto);
	List<UserDesignation> getAllUserDesignationById(int id);

}
