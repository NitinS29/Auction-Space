package com.auctionspace.utils;

import com.auctionspace.controller.IObserver;
//import java.util.Iterator;


public class ItemBid{

	public String bid_id;
	public String username;
	public String item_id;
	public float bid_amount;
	
	public float getBid_amount(){
		return bid_amount;
	}
	public void setBid_amount(float bid_amount)
	{
		this.bid_amount = bid_amount;
	}
	public String getItem_id(){
		return item_id;
	}
	public void setitem_id(String item_id)
	{
		this.item_id = item_id;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getBid_id(){
		return bid_id;
	}
	public void setBid_id(String bid_id)
	{
		this.bid_id = bid_id;
	}
	
	/*@Override
	public IObserver addBidder(IObserver iBidder) {
		// TODO Auto-generated method stub
		
		return null;
	}*/

}
