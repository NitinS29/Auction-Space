package com.auctionspace.utils;

import com.auctionspace.controller.BidOwner;
import com.auctionspace.controller.IObserver;
import com.auctionspace.dao.BidDao;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.model.BidModel;
import com.auctionspace.model.ItemsModel;

public class BidUtils implements IBid{
	@Override
	public IObserver removeBidder(IObserver iBidder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void notifyBidder(String bidOwnerEmail, String itemName, float bidAmount) {
		// TODO Auto-generated method stub
		//call BidOwner.update function here
		IObserver bidOwner = new BidOwner();
		bidOwner.update(bidOwnerEmail,itemName,bidAmount);
	}
	
	public boolean validateBid(float bidAmount, float item_price)
	{
		boolean flag = false;
		if(bidAmount > item_price)
		{
			flag = true;
		}
		return flag;
	}

	@Override
	public IObserver addBidder(IObserver iBidder) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean addBid(BidModel bid){
		boolean result = BidDao.getInstance().addBid(bid);
		return result;
	}

	@Override
	public void notifyBidder() {
		// TODO Auto-generated method stub
		
	}
}
