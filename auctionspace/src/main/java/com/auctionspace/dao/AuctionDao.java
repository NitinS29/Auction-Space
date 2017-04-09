package com.auctionspace.dao;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.auctionspace.model.AuctionModel;

@Service
public class AuctionDao {
	@Autowired
	DataSource dataSource;

	@Autowired 
	JdbcTemplate jdbcTemplate;

	private static Logger logger = Logger.getLogger(ItemsDao.class);

	class AuctionMapper implements RowMapper<AuctionModel> {
		public AuctionModel mapRow(ResultSet rs, int arg1) throws SQLException {
			AuctionModel auction = new AuctionModel();
			/*item.setItemId((int)rs.getInt("item_id"));
			item.setItemDisplayName(rs.getString("item_display_name"));
			item.setPrice(rs.getFloat("price"));
			item.setQuantity(rs.getInt("quantity"));
			item.setStartTime(rs.getString("start_time"));
			item.setEndTime(rs.getString("end_time"));
			item.setDescription(rs.getString("description"));
			item.setSeller(rs.getString("seller"));
			item.setLocation(rs.getString("location"));*/
			return auction;
		}
	}

	public void registerUser(AuctionModel auction) {
		try {
			logger.info("In register user for auction of an item method");
			logger.debug("log " + auction.getItemId() + auction.getFname());
			String sql = "insert into Registered_Users (item_id, fname, emailId) values (?, ?, ?) ";
			logger.info("query=" + sql);
			this.jdbcTemplate.update(sql, new Object[] {auction.getItemId(), auction.getFname(), ManageUsersDao.getInstance().getUserEmailId(auction.getFname())}) ;
		} catch (Exception e) {
			logger.error("Error in registerUser: " + e.getMessage());
		}
	}
	
	/*public JSONArray getAllItems() {
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
		InputStream inputStream = null;
		try {
			logger.info("In add item method");
			Part filePart = items.getImage();
			if (filePart != null) {
				// debug messages
				System.out.println(filePart.getName());
				System.out.println(filePart.getSize());
				System.out.println(filePart.getContentType());

				// obtains input stream of the upload file
				inputStream = filePart.getInputStream();
			}

			String sql = "insert into Items (item_display_name, price, quantity, start_time, end_time, seller, location, description, image) values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			logger.info("query=" + sql);
			this.jdbcTemplate.update(sql, new Object[] {items.getItemDisplayName(), items.getPrice(), items.getQuantity(), items.getStartTime(), items.getEndTime(), items.getSeller(), items.getLocation(), items.getDescription(), inputStream}) ;
		} catch (Exception e) {
			logger.error("Error in addItem: " + e.getMessage());
		}
		return true;
	}

	public ItemsModel getItemDetails(String itemId) {
		ItemsModel item = null;
		try {
			String query = "select * from Items where item_id='" + itemId + "'";
			logger.error("in getItemDetails: " + query);
			item = this.jdbcTemplate.queryForObject(query,  new ItemMapper());
		} catch (Exception e) {
			logger.error("Error in getItemDetails: " + e.getMessage());
		}
		return item;
	}*/
}