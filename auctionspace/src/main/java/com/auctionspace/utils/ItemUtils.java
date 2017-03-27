package com.auctionspace.utils;

import java.sql.ResultSet;
import java.util.Date;

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
		ResultSet itemsList = itemDao.getAllItems();
		try {
			while (itemsList.next()) {
				JSONObject item = new JSONObject();
				item.put("itemId", (long) itemsList.getLong("item_id"));
				item.put("itemDisplayName", itemsList.getString("item_display_name"));
				item.put("price", (float) itemsList.getFloat("price"));
				item.put("quantity", (int) itemsList.getInt("quantity"));
				item.put("noOfBids", (int) itemsList.getInt("no_of_bids"));
				item.put("startTime", (Date) itemsList.getDate("start_time"));
				item.put("endTime", (Date) itemsList.getDate("end_time"));
				item.put("seller", itemsList.getString("seller").toString());
				item.put("location", itemsList.getString("location").toString());
				item.put("currentPrice", (float) itemsList.getFloat("current_price"));
				item.put("description", itemsList.getString("description").toString());
				items.put(item);
			}
		} catch (Exception e) {
			logger.info("Error in getItems" + e.getMessage());
		}
		return items;
	}

	public String addItems(ItemsModel items) {
	//	for (int i = 0; i < items.length; i++)
	//	{
			logger.debug("Details" + items.getDescription());
//		}
		return null;
	}
}
