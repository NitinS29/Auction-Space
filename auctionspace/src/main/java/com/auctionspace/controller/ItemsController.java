package com.auctionspace.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auctionspace.model.ItemsModel;
import com.auctionspace.utils.ItemUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/Items")
public class ItemsController {
	private static Logger logger = Logger.getLogger(ItemsController.class);

	@RequestMapping(value = "/getItemsList", method = RequestMethod.GET)
	public @ResponseBody String getItemsList() {
		logger.debug("In get User log");
		ItemUtils itemUtil = new ItemUtils();
		return itemUtil.getListOfItems().toString();
	}

	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	@ResponseBody
	public String addItem(HttpServletRequest request, @RequestBody String payload) {
		Gson gson = new GsonBuilder().create();
		logger.info("Payload" + payload);
		try {
		ItemsModel items = (ItemsModel)gson.fromJson(payload, ItemsModel.class);
		ItemUtils itemUtil = new ItemUtils();
		String message = itemUtil.addItems(items);
		return message;
		} catch (Exception e) {
			logger.debug("Exception: " + e.getMessage());
		}
		return "Done";
		/*ItemUtils itemUtil = new ItemUtils();
		String message = itemUtil.addItems();
		return message;*/
	}
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@ResponseBody
	public String sayHello() {
		//model.addAttribute("msg", msg);
		return "helloWorld";
		
		
	}
}
