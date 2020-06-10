package com.mc.demo.thirdService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mc.demo.thirdService.repo.UserRepository;
import com.mc.demo.thirdService.service.dto.UserDesignation;
import com.mc.demo.thirdService.service.dto.UserDesignationDTO;
@Service
public class UserServiceImpl implements UserServiceIface{

	UserRepository userRepository;
	
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
	
		this.userRepository = userRepository;
	}

	@Override
	public UserDesignationDTO save(UserDesignationDTO userDto) {
		
		return userDto;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserDesignation> getAllUserDesignationById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
