package com.auctionspace.dao;

public class ConnectionData implements IConnectionData {
	String jdbcDriver = "com.mysql.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/ssdiproject?useSSL=false";
	String username = "root";
	String password = "admin123";
	
	@Override
	public String getDriver() {
		return jdbcDriver;
	}
	
	@Override
	public String getUrl() {
		return dbUrl;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
}
