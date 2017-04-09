package com.auctionspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.auctionspace.dao.AuctionDao;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.dao.ManageUsersDao;
import com.auctionspace.model.AuctionModel;
import com.auctionspace.model.ItemsModel;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@RestController
@RequestMapping("/Auction")
@MultipartConfig(maxFileSize = 16177215) 
public class AuctionController {
	private static Logger logger = Logger.getLogger(AuctionController.class);

	@Autowired
	public AuctionDao auctionService;
	@Autowired
	public ItemsDao itemService;
	
	@RequestMapping(value = "/registerUserforItemAuction", method = RequestMethod.POST)
	public ModelAndView registerUserForItemAuction(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("auction") AuctionModel auction) {
		logger.info("Id: " + auction.getItemId() + "fname:"  + auction.getFname());
		auctionService.registerUser(auction);
		ModelAndView mav = new ModelAndView("ItemInformation");
		ItemsModel itemInfo = itemService.getItemDetails(Integer.toString(auction.getItemId()));
		mav.addObject("item", itemInfo);
		mav.addObject("itemId", Integer.toString(auction.getItemId()));
		return mav;
	}
}