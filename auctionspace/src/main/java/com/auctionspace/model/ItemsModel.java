package com.auctionspace.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ItemsModel {
	private int itemId;
	private String itemDisplayName;
	private float price;
	private int quantity;
	private CommonsMultipartFile[] image;
	private String imagePath;
	//private int noOfBids; 
	private String startTime;
	private String endTime;
	private String seller;
	private String location;
	//private float currentPrice;
	private String description;
	private String status;

	public int getItemId() {
		return itemId;
	}
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
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
	
	public String getSeller() {
		return seller;
	}
	
	public void setSeller(String seller) {
		this.seller = seller;
	}
	
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
	
	public CommonsMultipartFile[] getImage() {
		return image;
	}
	
	public void setImage(CommonsMultipartFile[] image) {
		this.image = image;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}