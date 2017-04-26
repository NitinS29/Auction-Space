package com.auctionspace.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auctionspace.dao.BidDao;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.dao.ManageUsersDao;
import com.auctionspace.model.BidModel;
import com.auctionspace.model.ItemsModel;
import com.auctionspace.model.UserModel;

@Service
public class EmailTask {
	private static Logger logger = Logger.getLogger(EmailTask.class);

	//@Autowired
	public BidDao bidService = BidDao.getInstance().instance;
	//@Autowired
	public ItemsDao itemService =  ItemsDao.getInstance().instance;
	//@Autowired
	ManageUsersDao userService =  ManageUsersDao.getInstance().instance;

	public boolean sendEmailDetails(int itemId) {
		boolean result  = false;
		try {
			//get the seller email id from seller name
			String to = userService.getUserEmailId(itemService.getSeller(itemId));

			//get item details from the item table
			ItemsModel itemInfo = itemService.getItemDetails(Integer.toString(itemId));

			//get username from the bid table
			BidModel bidInfo = bidService.getWinningBid(itemId);

			//get the buyer details from the bid table
			UserModel userInfo = userService.getUserDetails(bidInfo.getusername());

			EmailUtils util = new EmailUtils();
			result = util.sendBuyerDetails(to, itemInfo, bidInfo, userInfo);
		}
		catch(Exception e) {
			return false;
		}
		return result;
	}

	public List<Integer> getItemIdForClosedBids() {
		List<Integer> bidInfo = null;
		try {
			bidInfo = bidService.getListOfClosedBids();
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			logger.error("Error in getListOfClosedBids" + exceptionAsString);
		}
		return bidInfo;
	}

	public void sendMailToSellers() {
		List<Integer> itemIdList = getItemIdForClosedBids();
		for(int i = 0; i < itemIdList.size(); i++) {
			sendEmailDetails(itemIdList.get(i));
		}
	}
}
