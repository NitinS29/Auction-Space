package com.auctionspace.dao;

import com.auctionspace.model.LoginModel;
import com.auctionspace.model.UserModel;

public interface IManageUsersDao {
	
	public void registerUser(UserModel user);
	
	public UserModel validateUser(LoginModel login);

	String getUserEmailId(String fname);
	
}
