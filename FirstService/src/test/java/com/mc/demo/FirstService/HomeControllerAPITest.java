package com.mc.demo.FirstService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mc.demo.FirstService.controller.HomeController;
import com.mc.demo.FirstService.controller.response.UserDetailModelRequest;
@ExtendWith(SpringExtension.class)
@WebMvcTest(HomeController.class)
@TestPropertySource(locations = {
		   "classpath:testConfig.properties"})
public class HomeControllerAPITest {
	final static Logger logger = LoggerFactory.getLogger(HomeControllerAPITest.class);
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void getTest() throws Exception {
		RequestBuilder request=MockMvcRequestBuilders.get("/status/check");
		MvcResult result=mockMvc.perform(request).andReturn();
		logger.info(result.getResponse().getContentAsString());
		assertEquals("Service is up on port 8999", result.getResponse().getContentAsString());
	}
	
	@Test
	void postTest() throws Exception {
		UserDetailModelRequest requestBody=new UserDetailModelRequest();
		requestBody.setName("Dhananjay");
		requestBody.setSurName("Tiwari");
		ObjectMapper om=new ObjectMapper();
		String jsonBody=om.writeValueAsString(requestBody);
		logger.info("Post request in json format :{}",jsonBody);
		RequestBuilder request=MockMvcRequestBuilders.post("/allresponse").contentType(MediaType.APPLICATION_JSON_VALUE).content(jsonBody);
		MvcResult result=mockMvc.perform(request).andReturn();
		logger.info(result.getResponse().getContentAsString());
	
	}
	

}
