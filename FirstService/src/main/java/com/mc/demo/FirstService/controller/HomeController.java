package com.mc.demo.FirstService.controller;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mc.demo.FirstService.controller.response.UserDetailModelRequest;
import com.mc.demo.FirstService.controller.response.UserRest;
import com.mc.demo.FirstService.controller.response.UserRestResponse;

@RestController
@RequestMapping
public class HomeController {
	@Autowired
	private Environment environment;
	final static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/status/check")
	public String status() {
		return "Service is up on port " + environment.getProperty("local.server.port");
	}

	@PostMapping("/allresponse")
	public ResponseEntity<UserRestResponse> createResponse(@RequestBody UserDetailModelRequest userDetailsrequest) {
		UserRestResponse originalresponse = new UserRestResponse();
		String finalresponse = null;
		try {
			RestTemplate restTemplate1 = new RestTemplate();
			String secondServiceUrl = "http://localhost:7777/hello";
			logger.info("Calling second microservice");
			ResponseEntity<String> getResponse = restTemplate1.exchange(secondServiceUrl, HttpMethod.GET, null,
					String.class);

			originalresponse.setResponse(getResponse.getBody());
			finalresponse = originalresponse.getResponse();

		} catch (Exception e) {
			logger.error("Error While calling second microservice due to : {}", e.getMessage());

		}
		try {
			String thirdServiceUrl = "http://localhost:9999/users";
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<UserDetailModelRequest> requestEntity = new HttpEntity<>(userDetailsrequest, headers);

			RestTemplate restTemplate2 = new RestTemplate();
			logger.info("Calling third microservice");
			ResponseEntity<UserRest> postResponse = restTemplate2.exchange(thirdServiceUrl, HttpMethod.POST,
					requestEntity, UserRest.class);

			originalresponse.setResponse(postResponse.getBody().getName());
			finalresponse = finalresponse + " " + originalresponse.getResponse();
			originalresponse.setResponse(postResponse.getBody().getSurName());
			finalresponse = finalresponse + " " + originalresponse.getResponse();

		} catch (Exception e) {
			logger.error("Error While calling third microservice due to : {}", e.getMessage());
		}
		originalresponse.setResponse(finalresponse);
		logger.debug("Microservice communication between services has completed successfully with final response: {}",
				originalresponse);
		return new ResponseEntity<UserRestResponse>(originalresponse, HttpStatus.OK);
	}
}
