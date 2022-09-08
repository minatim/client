package com.timeline.client;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.timeline.client.controller.UserClientController;

@SpringBootTest
//@WebMvcTest
class ClientApplicationTests {
	@Autowired
	private UserClientController controller;
	@Mock
	private RestTemplate restTemplate;

	@Test
	public void getDemoTest() throws Exception {
		ResponseEntity<String> responseEntity = new ResponseEntity<>("ok", HttpStatus.OK);
		Mockito.when(restTemplate.getForEntity("http://localhost:8082/client/demo", String.class))
				.thenReturn(responseEntity);
		ResponseEntity<String> resp = controller.getDemo();
		Assertions.assertEquals(responseEntity.getStatusCode(), resp.getStatusCode());
	}
}
