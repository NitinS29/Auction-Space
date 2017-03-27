package com.auctionspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.auctionspace.dao.ItemsDao;
import com.auctionspace.model.ItemsModel;
import com.auctionspace.utils.ItemUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@RestController
@RequestMapping("/Items")
public class ItemsController {
	private static Logger logger = Logger.getLogger(ItemsController.class);
	@Autowired
	public ItemsDao userService;

	@RequestMapping(value = "/getItemsList", method = RequestMethod.GET)
	public @ResponseBody String getItemsList() {
		logger.debug("In getItemsList");
		ItemUtils itemUtil = new ItemUtils();
		return itemUtil.getListOfItems().toString();
	}

	@RequestMapping(value = "/displayItems", method = RequestMethod.GET)
	public ModelAndView displayItems(HttpServletRequest request, HttpServletResponse response) {
		logger.debug("In displayItems");
		ModelAndView mav = new ModelAndView("DisplayItems");
		ItemUtils itemUtil = new ItemUtils();
		mav.addObject("items", itemUtil.getListOfItems().toString());
		return mav;
	}

	@RequestMapping(value = "/processAddItem", method = RequestMethod.POST)
	public ModelAndView addItem(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("item") ItemsModel item) {
		ItemUtils itemUtil = new ItemUtils();
		logger.debug("In processAddItem" + item.getDescription() + item.getItemDisplayName() + item.getEndTime() + item.getStartTime() + item.getLocation());
		itemUtil.addItems(item);
		ModelAndView mav = new ModelAndView("DisplayItems");
		mav.addObject("items", itemUtil.getListOfItems().toString());
		mav.addObject("itemName", item.getItemDisplayName());
		return mav;
	}

	@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("AddItems");
		mav.addObject("item", new ItemsModel());
		return mav;
	}

	@RequestMapping(value = "/addItemREST", method = RequestMethod.POST)
	@ResponseBody
	public String addItem(HttpServletRequest request, @RequestBody String payload) {
		boolean result = false;
		Gson gson = new GsonBuilder().create();
		logger.info("Payload" + payload);
		try {
			ItemsModel items = (ItemsModel)gson.fromJson(payload, ItemsModel.class);
			ItemUtils itemUtil = new ItemUtils();
			result = itemUtil.addItems(items);
		} catch (Exception e) {
			logger.debug("Exception: " + e.getMessage());
		}
		if (result) {
			return "Item added successfully";
		} else {
			return "Error in adding item, try again";
		}
	}
}