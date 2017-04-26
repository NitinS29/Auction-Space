package com.auctionspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.auctionspace.dao.BidDao;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.dao.ManageUsersDao;
import com.auctionspace.model.ItemsModel;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@RestController
@RequestMapping("/Items")
public class ItemsController {
	private static Logger logger = Logger.getLogger(ItemsController.class);

	@Autowired
	public ItemsDao itemService;

	@Autowired
	public ManageUsersDao userService;

	@Autowired
	public BidDao bidService;

	@RequestMapping(value = "/getItemsList", method = RequestMethod.GET)
	public @ResponseBody String getItemsList() {
		logger.debug("In getItemsList");
		return itemService.getAllItems().toString();
	}

	@RequestMapping(value = "/getItemsList/{fname}", method = RequestMethod.GET)
	public @ResponseBody String getItemsListForUser(@PathVariable("fname")String fname, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("In getAllItemsForUser");
		return itemService.getAllItemsForUser(fname).toString();
	}

	@RequestMapping(value = "/getItemsAuctionedByUser/{fname}", method = RequestMethod.GET)
	public @ResponseBody String getItemsAuctionedByUser(@PathVariable("fname")String fname, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("In getItemsAuctionedByUser");
		return itemService.getItemsAuctionedByUser(fname).toString();
	}

	@RequestMapping(value = "/getItemsBoughtByUser/{fname}", method = RequestMethod.GET)
	public @ResponseBody String getItemsBoughtByUser(@PathVariable("fname")String fname, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("In getItemsAuctionedByUser");
		return itemService.getItemsAuctionedByUser(fname).toString();
	}

	@RequestMapping(value = "/displayItems/{fname}", method = RequestMethod.GET)
	public ModelAndView displayItems(@PathVariable("fname")String fname, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("In displayItems");
		ModelAndView mav = new ModelAndView("DisplayItems");
		mav.addObject("items", itemService.getAllItems().toString());
		mav.addObject("fname", fname);
		return mav;
	}

	@RequestMapping(value = "/displayAuctionedItems/{fname}", method = RequestMethod.GET)
	public ModelAndView displayAuctionedItems(@PathVariable("fname")String fname, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("In displayAuctionedItems");
		ModelAndView mav = new ModelAndView("AuctionedItems");
		mav.addObject("items", itemService.getItemsAuctionedByUser(fname).toString());
		mav.addObject("fname", fname);
		return mav;
	}

	@RequestMapping(value = "/processAddItem", method = RequestMethod.POST)
	public ModelAndView addItem(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("item") ItemsModel item) {
		String fileName = "";
		String saveDirectory = "C:/Program Files/Apache Software Foundation/Tomcat 9.0/webapps/auctionspace/resources/static/images/";

		if (item.getImage() != null && item.getImage().length > 0) {
			try {
				for (CommonsMultipartFile aFile : item.getImage()) {
					if (!aFile.getOriginalFilename().equals("")) {
						String filePath = saveDirectory +  item.getSeller() + "_" + item.getItemId() + "_" + aFile.getOriginalFilename();
						aFile.transferTo(new File(filePath));
						fileName = item.getSeller() + "_" + item.getItemId() + "_" + aFile.getOriginalFilename();
						logger.info("File Path: " + fileName);
					}
				}
			} catch (Exception ex) {
				logger.error("Error in processAddItem: " + ex.getMessage());
			}
		}
		itemService.addItem(item, fileName);
		ModelAndView mav = new ModelAndView("DisplayItems");
		mav.addObject("items", itemService.getAllItems().toString());
		mav.addObject("itemName", item.getItemDisplayName());
		mav.addObject("fname", item.getSeller());
		return mav;
	}

	@RequestMapping(value = "/addItem/{user}", method = RequestMethod.GET)
	public ModelAndView showRegister(@PathVariable("user")String user, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("AddItems");
		mav.addObject("item", new ItemsModel());
		mav.addObject("seller", user);
		return mav;
	}

	@RequestMapping(value = "/getItemInformation", method = RequestMethod.GET)
	public ModelAndView getItemInformation(@RequestParam("itemId") String itemId, @RequestParam("fname") String fname, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("ItemInformation");
		ItemsModel itemInfo = itemService.getItemDetails(itemId);
		mav.addObject("item", itemInfo);
		mav.addObject("itemId", itemId);
		mav.addObject("fname", fname);
		mav.addObject("prevBid",bidService.getLastBid(itemInfo.getItemId()));
		mav.addObject("noOfBids",bidService.getNoOfBids(itemInfo.getItemId()));
		return mav;
	}
}