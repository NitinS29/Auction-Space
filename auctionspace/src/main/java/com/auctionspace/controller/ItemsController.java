package com.auctionspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.auctionspace.dao.ItemsDao;
import com.auctionspace.dao.ManageUsersDao;
import com.auctionspace.model.ItemsModel;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@RestController
@RequestMapping("/Items")
@MultipartConfig(maxFileSize = 16177215) 
public class ItemsController {
	private static Logger logger = Logger.getLogger(ItemsController.class);

	@Autowired
	public ItemsDao itemService;

	@Autowired
	public ManageUsersDao userService;
	
	@RequestMapping(value = "/getItemsList", method = RequestMethod.GET)
	public @ResponseBody String getItemsList() {
		logger.debug("In getItemsList");
		return itemService.getAllItems().toString();
	}

	@RequestMapping(value = "/displayItems/{fname}", method = RequestMethod.GET)
	public ModelAndView displayItems(@PathVariable("fname")String fname, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("In displayItems");
		ModelAndView mav = new ModelAndView("DisplayItems");
		mav.addObject("items", itemService.getAllItems().toString());
		mav.addObject("fname", fname);
		return mav;
	}

	@RequestMapping(value = "/processAddItem", method = RequestMethod.POST)
	public ModelAndView addItem(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("item") ItemsModel item) {
		itemService.addItem(item);
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
	
	@RequestMapping(value = "/getItemInformation/{itemId}", method = RequestMethod.GET)
	public ModelAndView getItemInformation(@PathVariable("itemId")String itemId, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("ItemInformation");
		ItemsModel itemInfo = itemService.getItemDetails(itemId);
		mav.addObject("item", itemInfo);
		mav.addObject("itemId", itemId);
		return mav;
	}
}