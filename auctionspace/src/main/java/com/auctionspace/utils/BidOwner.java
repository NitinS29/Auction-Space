package com.auctionspace.utils;

import com.auctionspace.utils.EmailUtils;

public class BidOwner implements IObserver{

	@Override
	public void update(String bidOwnerEmail, String itemName, float bidAmount) {
		//call email functionality here.
		EmailUtils email = new EmailUtils();
		email.send(bidOwnerEmail,itemName,bidAmount);
	}
}
