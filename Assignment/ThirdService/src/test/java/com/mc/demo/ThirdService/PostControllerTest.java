package com.mc.demo.ThirdService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mc.demo.thirdService.controller.PostController;
import com.mc.demo.thirdService.model.UserDetailModelRequest;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PostController.class)
public class PostControllerTest {
	@Autowired
	private MockMvc mockMvc;
	final static Logger logger = LoggerFactory.getLogger(PostControllerTest.class);


	@Test
	void postTest() throws Exception {
		
		UserDetailModelRequest requestBody=new UserDetailModelRequest();
		requestBody.setName("Dhananjay");
		requestBody.setSurName("Tiwari");
		ObjectMapper om=new ObjectMapper();
		String jsonBody=om.writeValueAsString(requestBody);
		logger.info("Post request in json :{}",jsonBody);
		RequestBuilder request=MockMvcRequestBuilders.post("/users").contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonBody);
		MvcResult result=mockMvc.perform(request).andReturn();
		logger.info(result.getResponse().getContentAsString());

	}
}
