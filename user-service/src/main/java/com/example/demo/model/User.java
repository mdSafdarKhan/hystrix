package com.example.demo.model;

public class User {
	
	private String userName;
	private String userOrder;
	
	public User(String userName, String userOrder) {
		super();
		this.userName = userName;
		this.userOrder = userOrder;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserOrder() {
		return userOrder;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userOrder=" + userOrder + "]";
	}
	
}
