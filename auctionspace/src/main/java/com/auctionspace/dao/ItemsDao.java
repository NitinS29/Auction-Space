package com.auctionspace.dao;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import com.auctionspace.model.ItemsModel;

@Service
public class ItemsDao {
	@Autowired
	DataSource dataSource;

	@Autowired 
	JdbcTemplate jdbcTemplate;

	private static Logger logger = Logger.getLogger(ItemsDao.class);

	public JSONArray getAllItems() {
		JSONArray items = new JSONArray();
		try {
			String query = "select * from Items";
			logger.error("in getAllItems: " + query);
			List<Map<String, Object>> itemsList = this.jdbcTemplate.queryForList(query);
			for (int i = 0; i < itemsList.size(); i++)
			{
				JSONObject item = new JSONObject();
				item.put("itemId", itemsList.get(i).get("item_id").toString());
				item.put("itemDisplayName", itemsList.get(i).get("item_display_name").toString());
				item.put("price", (float) itemsList.get(i).get("price"));
				item.put("quantity", (int) itemsList.get(i).get("quantity"));
				item.put("startTime", itemsList.get(i).get("start_time").toString());
				item.put("endTime", itemsList.get(i).get("end_time").toString());
				item.put("seller", itemsList.get(i).get("seller").toString());
				item.put("location", itemsList.get(i).get("location").toString());
				item.put("description", itemsList.get(i).get("description").toString());
				//item.put("currentPrice", (float) itemsList.get(i).get("current_price"));
				//item.put("noOfBids", (int) itemsList.get(i).get("no_of_bids"));
				items.put(item);
			}
		} catch (Exception e) {
			logger.error("Error in getAllItems: " + e.getMessage());
		}
		return items;
	}

	public boolean addItem(ItemsModel items) {
		try {
			logger.info("In add item method");
			String sql = "insert into Items (item_display_name, price, quantity, start_time, end_time, seller, location, description) values (?, ?, ?, ?, ?, ?, ?, ?) ";
			logger.info("query=" + sql);
			this.jdbcTemplate.update(sql, new Object[] {items.getItemDisplayName(), items.getPrice(), items.getQuantity(), items.getStartTime(), items.getEndTime(), items.getSeller(), items.getLocation(), items.getDescription()}) ;
		} catch (Exception e) {
			logger.error("Error in addItem: " + e.getMessage());
		}
		return true;
	}
}