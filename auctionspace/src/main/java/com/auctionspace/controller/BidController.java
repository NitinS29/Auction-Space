package com.auctionspace.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.auctionspace.dao.BidDao;
import com.auctionspace.model.BidModel;
import com.auctionspace.model.ItemsModel;
import com.auctionspace.model.LoginModel;
import com.auctionspace.utils.BidUtils;
//import com.auctionspace.utils.ItemUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.dao.ManageUsersDao;

@RestController
@RequestMapping("/Bid")
public class BidController {
	private static Logger logger = Logger.getLogger(BidController.class);
	@Autowired
	public BidDao userService;
	@Autowired
	public ItemsDao itemsDao;
	@Autowired
	ManageUsersDao userDao;
	
	  @RequestMapping(value = "/bidProcess/{itemId}")
	  public ModelAndView setBid(@PathVariable String itemId, HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("bid") BidModel bid) {
	    boolean result = false;
		ModelAndView mav = null;
	    //ItemsDao itemDao = new ItemsDao();	    
	    BidUtils bidUtils = new BidUtils();   
	    //ManageUsersDao user = new ManageUsersDao();
	    if (bidUtils.validateBid(bid.getbid_amount(), itemsDao.getItemPrice(bid.getitem_id()))) {
	    result = userService.addBid(bid);}
	    if(result){
	    
	    mav = new ModelAndView("ItemInformation");
		ItemsModel itemInfo = itemsDao.getItemDetails(itemId);
		mav.addObject("item", itemInfo);
	    mav.addObject("message","Bid was successful !!!");
		mav.addObject("prevBid",userService.getLastBid(bid.getitem_id()));
		mav.addObject("noOfBids",userService.getNoOfBids(bid.getitem_id()));
		bidUtils.notifyBidder(userDao.getUserEmailId(itemsDao.getSeller(bid.getitem_id())),itemInfo.getItemDisplayName(),bid.getbid_amount());
	    } else {
	    mav = new ModelAndView("ItemInformation");
		ItemsModel itemInfo = itemsDao.getItemDetails(itemId);
		mav.addObject("item", itemInfo);
		mav.addObject("prevBid",userService.getLastBid(bid.getitem_id()));
		mav.addObject("noOfBids",userService.getNoOfBids(bid.getitem_id()));
	    mav.addObject("message", "Bid is invalid!!");
	    }
	    return mav;
	  }
	
	  @RequestMapping(value = "/bidding/{itemId}")
	  public ModelAndView getBid(@PathVariable String itemId, HttpServletRequest request, HttpServletResponse response,
	  @ModelAttribute("bid") BidModel bid) {
			ModelAndView mav = new ModelAndView("Bid");
			mav.addObject("user", request.getSession().getAttribute("userId"));
			mav.addObject("itemId", itemId);
			//mav.addObject("item",itemModel);
			//mav.addObject("Bid", new BidModel());
			return mav;
	  
	  }
}
