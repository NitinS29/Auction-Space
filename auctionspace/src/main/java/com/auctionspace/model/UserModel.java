package com.auctionspace.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserModel {
	
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	private int phone;
	@NotEmpty
	private String fname;
	private String mname;
	private String lname;
		
	@NotEmpty
	@Email
	private String emailId;

	private String address;
	
	public UserModel(){
		
	}
	
	public UserModel(String username, String password, String fName,String lName,String mName, String emailId, int phone, String address)
	{
		this.username = username;
		this.password = password;
		this.fname = fName;
		this.lname = lName;
		this.mname = mName;
		//this.dob = dob;
		this.emailId = emailId;
		this.phone = phone;
		this.address = address;
	}
	
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getFname()
	{
		return fname;
	}
	
	public void setFname(String fName)
	{
		this.fname = fName;
	}
	
	public String getMname()
	{
		return mname;
	}
	
	public void setMname(String mName)
	{
		this.mname = mName;
	}
	public String getLname()
	{
		return lname;
	}
	
	public void setLname(String lName)
	{
		this.lname = lName;
	}
		
	public String getEmail()
	{
		return emailId;
	}
	
	public void setEmail(String emailId)
	{
		this.emailId = emailId;
	}
	public int getPhone()
	{
		return phone;
	}
	
	public void setPhone(int phone)
	{
		this.phone = phone;
	}
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
}
