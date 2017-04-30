package com.auctionspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.auctionspace.dao.AuctionDao;
import com.auctionspace.dao.BidDao;
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
	@Autowired
	ManageUsersDao userService;
	@Autowired
	BidDao bidService;

	@RequestMapping(value = "/registerUserforItemAuction", method = RequestMethod.POST)
	public ModelAndView registerUserForItemAuction(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("auction") AuctionModel auction) {
		logger.info("Id: " + auction.getItemId() + "fname:"  + auction.getFname());
		auction.setEmailId(userService.getUserEmailId(auction.getFname()));
		auctionService.registerUser(auction);
		ModelAndView mav = new ModelAndView("ItemInformation");
		ItemsModel itemInfo = itemService.getItemDetails(Integer.toString(auction.getItemId()));
		mav.addObject("item", itemInfo);
		mav.addObject("itemId", Integer.toString(auction.getItemId()));
		mav.addObject("message", "Registered for auction of " + itemInfo.getItemDisplayName());
		return mav;
	}

	@RequestMapping(value = "/getAllAuctions/{fname}" , method=RequestMethod.GET)
	public @ResponseBody String getAllAuctionInfo(@PathVariable("fname")String fname,HttpServletRequest request, HttpServletResponse response) {
		logger.info("In getAllItemsForAdmin:");
		return  itemService.getAllItemsForAdmin().toString();
	}

	@RequestMapping(value = "/displayItemsAdmin/{fname}", method = RequestMethod.GET)
	public ModelAndView displayItemsAdmin(@PathVariable("fname")String fname, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("In displayItemsAdmin");
		ModelAndView mav = new ModelAndView("AllAuctionInfo");
		mav.addObject("items", itemService.getAllItemsForAdmin().toString());
		mav.addObject("fname", fname);
		return mav;
	}

	@RequestMapping(value = "/ItemInfoAdmin", method = RequestMethod.GET)
	public ModelAndView stopAuction(@RequestParam("itemId") String itemId, @RequestParam("fname") String fname, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("auction") AuctionModel auction) {
		logger.debug("In stopAuctionAdmin");
		ModelAndView mav = new ModelAndView("ItemInfoAdmin");
		ItemsModel itemInfo = itemService.getItemDetails(Integer.toString(auction.getItemId()));
		mav.addObject("item", itemInfo);
		mav.addObject("itemId", itemId);
		mav.addObject("fname", fname);
		mav.addObject("prevBid",bidService.getHighestBid(itemInfo.getItemId()));
		mav.addObject("noOfBids",bidService.getNoOfBids(itemInfo.getItemId()));
		return mav;
	}

	@RequestMapping(value = "/stopAuction/{itemId}" ,method = RequestMethod.POST)
	public ModelAndView stopAuctionAdmin(@PathVariable String itemId, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("auction") AuctionModel auction) {
		logger.debug("In stopAuction");
		auctionService.stopAuction(Integer.parseInt(itemId));
		ModelAndView mav = new ModelAndView("ItemInfoAdmin");
		ItemsModel itemInfo = itemService.getItemDetails(itemId);
		mav.addObject("item", itemInfo);
		mav.addObject("itemId", itemId);
		mav.addObject("message", "The auction has been stopped for " + itemInfo.getItemDisplayName());
		return mav;
	}

	@RequestMapping(value = "/getItemInfo", method = RequestMethod.GET)
	public ModelAndView getItemInformation(@RequestParam("itemId") String itemId, @RequestParam("fname") String fname, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("ItemInformation");
		ItemsModel itemInfo = itemService.getItemDetails(itemId);
		mav.addObject("item", itemInfo);
		mav.addObject("itemId", itemId);
		mav.addObject("fname", fname);
		mav.addObject("prevBid",bidService.getHighestBid(itemInfo.getItemId()));
		mav.addObject("noOfBids",bidService.getNoOfBids(itemInfo.getItemId()));
		return mav;
	}
}