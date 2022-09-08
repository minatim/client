package com.timeline.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client")
public class UserClientController {
	
@Autowired
private RestTemplate restTemplate;

private static final String baseUrl="http://localhost:8081/server";
private static final String client = "client";
	@GetMapping("/demo")
	//@CircuitBreaker(name=client, fallbackMethod = "clientFallback")
	//@Retry(name = client)
	//@RateLimiter(name = client)
	public ResponseEntity<String> getDemo(){
		System.out.println("---inside client----");
		//System.out.println("---retry method called----"+count++ );
		return restTemplate.getForEntity(baseUrl+"/test", String.class);
	}
	/*
	 * @GetMapping("/abc") public String clientFallback(Exception ex){ return
	 * "client fallback--"; }
	 */
}
