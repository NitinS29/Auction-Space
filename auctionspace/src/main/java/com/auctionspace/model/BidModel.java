package com.auctionspace.model;

public class BidModel {
	public int bid_id;
	public float bid_amount;
	public int item_id;
	public String username;
	
	public int getbid_id(){
		return bid_id;
	}
	
	public void setbid_id(int bid_id){
		this.bid_id = bid_id;
	}
	
	public float getbid_amount(){
		return bid_amount;
	}
	
	public void setbid_amount(float bid_amount){
		this.bid_amount = bid_amount;
	}
	
	public int getitem_id(){
		return item_id;
	}
	
	public void setitem_id(int item_id){
		this.item_id = item_id;
	}
	
	public String getusername(){
		return username;
	}
	
	public void setusername(String username){
		this.username = username;
	}
}
