package com.mc.demo.SecondService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/hello")
public class SecondController {

	@GetMapping
	public String greet(){
		
		return "Hello";
	}


}
