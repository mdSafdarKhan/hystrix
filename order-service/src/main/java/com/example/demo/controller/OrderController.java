package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@GetMapping
	public List<Order> getOrders(){
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(UUID.randomUUID().toString(), "Description 1", new Date()));
		orders.add(new Order(UUID.randomUUID().toString(), "Description 2", new Date()));
		orders.add(new Order(UUID.randomUUID().toString(), "Description 3", new Date()));
		orders.add(new Order(UUID.randomUUID().toString(), "Description 4", new Date()));
		return orders;
	}
}
