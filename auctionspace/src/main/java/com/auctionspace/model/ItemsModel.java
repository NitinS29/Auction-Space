package com.auctionspace.model;

import java.util.Date;

public class ItemsModel {
	//private long itemId;
	private String itemDisplayName;
	private float price;
	private int quantity;
	//private int noOfBids; 
	private String startTime;
	private String endTime;
	//private String seller;
	private String location;
	//private float currentPrice;
	private String description;

/*	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}*/
	public String getItemDisplayName() {
		return itemDisplayName;
	}
	public void setItemDisplayName(String itemDisplayName) {
		this.itemDisplayName = itemDisplayName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/*public int getNoOfBids() {
		return noOfBids;
	}
	public void setNoOfBids(int noOfBids) {
		this.noOfBids = noOfBids;
	}*/
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/*public String getSeller() {
		return seller;
	}
	public void setSeller(String seller) {
		this.seller = seller;
	}*/
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	/*public float getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}*/
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}