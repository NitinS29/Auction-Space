package com.auctionspace.utils;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import com.auctionspace.dao.ItemsDao;
import com.auctionspace.model.ItemsModel;

public class ItemUtils {
	private static Logger logger = Logger.getLogger(ItemUtils.class);
	ItemsDao itemDao = ItemsDao.getInstance();

	public JSONArray getListOfItems() {
		JSONArray items = new JSONArray();
		List<Map<String, Object>> itemsList = ItemsDao.getInstance().getAllItems();
		try {
			for (int i = 0; i < itemsList.size(); i++)
			{
				JSONObject item = new JSONObject();
				//String itemId = itemsList.get(i).get("item_id").toString();
				String itemDisplayName = itemsList.get(i).get("item_display_name").toString();
				float price = (float) itemsList.get(i).get("price");
				int quantity = (int) itemsList.get(i).get("quantity");
				//int noOfBids = (int) itemsList.get(i).get("no_of_bids"); 
				String startTime = itemsList.get(i).get("start_time").toString();
				String endTime = itemsList.get(i).get("end_time").toString();
				String seller = itemsList.get(i).get("seller").toString();
				String location = itemsList.get(i).get("location").toString();
				//float currentPrice = (float) itemsList.get(i).get("current_price");
				String description = itemsList.get(i).get("description").toString();

				//item.put("itemId", itemId);
				item.put("itemDisplayName", itemDisplayName);
				item.put("price", price);
				item.put("quantity", quantity);
				//item.put("noOfBids", noOfBids);
				item.put("startTime", startTime);
				item.put("endTime", endTime);
				item.put("seller", seller);
				item.put("location", location);
				//item.put("currentPrice", currentPrice);
				item.put("description", description);
				items.put(item);
			}
		} catch (Exception e) {
			logger.info("Error in getItems" + e.getMessage());
		}
		return items;
	}

	public boolean addItems(ItemsModel items) {
		boolean result = ItemsDao.getInstance().addItem(items);
		return result;
	}
}
