package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Configuration
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	@HystrixCommand(fallbackMethod = "getUsers_fallback")
	public List<User> getUsers(){
		String orders1 = restTemplate.getForObject("http://localhost:8081/orders", String.class);
		String orders2 = restTemplate.getForObject("http://localhost:8081/orders", String.class);
		List<User> users = new ArrayList<User>();
		users.add(new User("Person 1", orders1));
		users.add(new User("Person 2", orders2));
		return users;
	}
	
	@SuppressWarnings("unused")
	private List<User> getUsers_fallback() {
		return Arrays.asList(new User("FALLBACK USER", "FALLBACK USER'S ORDER"));
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
