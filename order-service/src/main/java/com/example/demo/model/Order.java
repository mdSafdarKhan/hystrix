package com.example.demo.model;

import java.util.Date;

public class Order {

	private String orderId;
	private String orderDescription;
	private Date orderDate;
	
	public Order(String orderId, String orderDescription, Date orderDate) {
		super();
		this.orderId = orderId;
		this.orderDescription = orderDescription;
		this.orderDate = orderDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public Date getOrderDate() {
		return orderDate;
	}
	
}
