package com.mc.demo.thirdService.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mc.demo.thirdService.model.UserDesignationRequestModel;
import com.mc.demo.thirdService.model.UserDetailModelRequest;
import com.mc.demo.thirdService.service.UserServiceImpl;
import com.mc.demo.thirdService.service.dto.UserDesignation;
import com.mc.demo.thirdService.service.dto.UserDesignationDTO;
import com.mc.demo.thirdService.ui.model.response.UserResponse;
import com.mc.demo.thirdService.ui.model.response.UserRest;

@RestController
@RequestMapping("/users")
public class PostController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	final static Logger logger = LoggerFactory.getLogger(PostController.class);

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@RequestBody UserDetailModelRequest userDetails) {
		ResponseEntity<UserRest> response = null;
		if (userDetails != null) {

			UserRest returnValue = new UserRest();
			returnValue.setName(userDetails.getName());
			returnValue.setSurName(userDetails.getSurName());
			logger.debug("Calling Post API with usersDetails", userDetails);
			response = new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);

		} else {
			logger.error("Invalid request, UserDetails is null");
		}
		return response;

	}

	@PostMapping("/usersdesignation")
	public UserResponse saveUsersDesignation(@RequestBody UserDetailModelRequest designationRequest) {

		UserResponse responseBody = new UserResponse();
		UserDesignationDTO userDesignationDTO = new UserDesignationDTO();
		BeanUtils.copyProperties(designationRequest, userDesignationDTO);
		UserDesignationDTO response = userServiceImpl.save(userDesignationDTO);
		BeanUtils.copyProperties(response, responseBody);
		return responseBody;

	}
}
