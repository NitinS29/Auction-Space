package com.auctionspace.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.apache.log4j.Logger;
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

	public BidDao bidDao = BidDao.getInstance();
	public ItemsDao itemDao =  ItemsDao.getInstance();
	public ManageUsersDao userDao =  ManageUsersDao.getInstance();

	public boolean sendEmailDetails(int itemId) {
		boolean result  = false;
		try {
			//get the seller email id from seller name
			String to = userDao.getUserEmailId(itemDao.getSeller(itemId));

			//get item details from the item table
			ItemsModel itemInfo = itemDao.getItemDetails(Integer.toString(itemId));

			//get username from the bid table
			BidModel bidInfo = bidDao.getWinningBid(itemId);

			//get the buyer details from the bid table
			UserModel userInfo = userDao.getUserDetails(bidInfo.getusername());

			EmailUtils util = new EmailUtils();
			result = util.sendBuyerDetails(to, itemInfo, bidInfo, userInfo);
			
			itemDao.setSentMail(Integer.toString(itemId));
		}
		catch(Exception e) {
			return false;
		}
		return result;
	}

	public List<Integer> getItemIdForClosedBids() {
		List<Integer> bidInfo = null;
		try {
			bidInfo = bidDao.getListOfClosedBids();
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
