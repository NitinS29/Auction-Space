package com.auctionspace.utils;

import com.auctionspace.dao.BidDao;
import com.auctionspace.model.BidModel;

public class BidUtils implements IBid{
	@Override
	public IObserver removeBidder(IObserver iBidder) {
		return null;
	}

	@Override
	public void notifyBidder(String bidOwnerEmail, String itemName, float bidAmount) {
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
		return null;
	}
	
	public boolean addBid(BidModel bid){
		boolean result = BidDao.getInstance().addBid(bid);
		return result;
	}

	@Override
	public void notifyBidder() {
		
	}
}
