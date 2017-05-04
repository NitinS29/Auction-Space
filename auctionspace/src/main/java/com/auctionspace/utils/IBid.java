package com.auctionspace.utils;

import java.util.ArrayList;

public interface IBid {
	public IObserver addBidder(IObserver iBidder);
	public IObserver removeBidder(IObserver iBidder);
	public void notifyBidder();
	public ArrayList<IObserver> bidderList= new ArrayList<IObserver>();
	//void notifyBidder(String bidOwnerEmail);
	void notifyBidder(String bidOwnerEmail, String itemName, float bidAmount);
}
