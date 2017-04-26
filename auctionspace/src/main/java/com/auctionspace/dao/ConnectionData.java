package com.auctionspace.dao;

public class ConnectionData {
	String jdbcDriver = "com.mysql.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/ssdiproject?useSSL=false";
	String username = "root";
	String password = "admin123";
	
	public String getDriver() {
		return jdbcDriver;
	}
	
	
	public String getUrl() {
		return dbUrl;
	}
	
	
	public String getUsername() {
		return username;
	}
	
	
	public String getPassword() {
		return password;
	}
}