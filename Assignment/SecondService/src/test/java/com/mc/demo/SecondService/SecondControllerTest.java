package com.mc.demo.SecondService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mc.demo.SecondService.controller.SecondController;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SecondController.class)
public class SecondControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void getTest() throws Exception {
		RequestBuilder request=MockMvcRequestBuilders.get("/hello");
		MvcResult result=mockMvc.perform(request).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertEquals("Hello", result.getResponse().getContentAsString());
	}
	

}
