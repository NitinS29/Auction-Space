package com.auctionspace.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.auctionspace.dao.BidDao;
import com.auctionspace.model.BidModel;
import com.auctionspace.model.ItemsModel;
import com.auctionspace.model.UserModel;
import com.auctionspace.utils.BidUtils;
import com.auctionspace.utils.EmailUtils;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.dao.ManageUsersDao;

@RestController
@RequestMapping("/Bid")
public class BidController {
	private static Logger logger = Logger.getLogger(BidController.class);
	@Autowired
	public BidDao bidDao;
	@Autowired
	public ItemsDao itemDao;
	@Autowired
	ManageUsersDao userDao;

	@RequestMapping(value = "/bidProcess/{itemId}")
	public ModelAndView setBid(@PathVariable String itemId, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("bid") BidModel bid) {
		boolean result = false;
		ModelAndView mav = null;
		//ItemsDao itemDao = new ItemsDao();	    
		BidUtils bidUtils = new BidUtils();   
		logger.info("itemId:" + itemId);
		logger.info("itemId:" + bid.getitem_id());
		//ManageUsersDao user = new ManageUsersDao();
		if (bidUtils.validateBid(bid.getbid_amount(), itemDao.getItemPrice(bid.getitem_id()))) {
			result = bidDao.addBid(bid);}
		if(result){
			mav = new ModelAndView("ItemInformation");
			ItemsModel itemInfo = itemDao.getItemDetails(Integer.toString(bid.getitem_id()));
			mav.addObject("item", itemInfo);
			mav.addObject("fname", bid.getusername());
			mav.addObject("message","Bid was successful !!!");
			mav.addObject("prevBid",bidDao.getHighestBid(bid.getitem_id()));
			mav.addObject("noOfBids",bidDao.getNoOfBids(bid.getitem_id()));
			bidUtils.notifyBidder(userDao.getUserEmailId(itemDao.getSeller(bid.getitem_id())),itemInfo.getItemDisplayName(),bid.getbid_amount());
		} else {
			mav = new ModelAndView("ItemInformation");
			ItemsModel itemInfo = itemDao.getItemDetails(itemId);
			mav.addObject("fname", bid.getusername());
			mav.addObject("item", itemInfo);
			mav.addObject("prevBid",bidDao.getHighestBid(bid.getitem_id()));
			mav.addObject("noOfBids",bidDao.getNoOfBids(bid.getitem_id()));
			mav.addObject("message", "Bid is invalid!!");
		}
		return mav;
	}

	@RequestMapping(value = "/bidding/{itemId}")
	public ModelAndView getBid(@PathVariable String itemId, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("bid") BidModel bid) {
		ModelAndView mav = new ModelAndView("Bid");
		ItemsModel itemInfo = itemDao.getItemDetails(itemId);
		mav.addObject("user", request.getSession().getAttribute("userId"));
		mav.addObject("itemId", itemId);
		mav.addObject("item",itemInfo);
		//mav.addObject("Bid", new BidModel());
		return mav;
	}

	@RequestMapping(value = "/sendEmailDetails/{itemId}")
	public ModelAndView sendEmailDetails(@PathVariable int itemId, HttpServletRequest request, HttpServletResponse response) {
		//get the seller email id from seller name
		String to = userDao.getUserEmailId(itemDao.getSeller(itemId));

		//get item details from the item table
		ItemsModel itemInfo = itemDao.getItemDetails(Integer.toString(itemId));

		//get username from the bid table
		BidModel bidInfo = bidDao.getWinningBid(itemId);

		//get the buyer details from the bid table
		UserModel userInfo = userDao.getUserDetails(bidInfo.getusername());

		EmailUtils util = new EmailUtils();
		util.sendBuyerDetails(to, itemInfo, bidInfo, userInfo);
		ModelAndView mav = new ModelAndView("Welcome");
		mav.addObject("user", userInfo);
		HttpSession session = request.getSession();
		session.setAttribute("userId", userInfo.getUsername());
		return mav;
	}
}
