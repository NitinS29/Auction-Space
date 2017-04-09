package com.auctionspace.controller;

import com.auctionspace.model.ItemsModel;

public interface IObserver {
	
	//public void update(String message);

	void update(String bidOwnerEmail, String itemName, float bidAmount);

	//public void update(String bidOwnerEmail, ItemsModel Item);

}
