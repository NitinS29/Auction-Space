package com.auctionspace.model;

public class LoginModel {

	public String username;
	public String password;

	public LoginModel(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public LoginModel() {
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getUsername()
	{
		return username;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return password;
	}

}
