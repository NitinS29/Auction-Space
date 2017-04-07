package com.auctionspace.dao;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import com.auctionspace.model.ItemsModel;
public class ItemsDao { 
	DataSource dataSource = ConnectionUtility.getDataSource();
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

	public static ItemsDao instance = new ItemsDao();
	private static Logger logger = Logger.getLogger(ItemsDao.class);

	public static ItemsDao getInstance() {
		return instance;
	}

	public List<Map<String, Object>> getAllItems() {
		List<Map<String, Object>> resultList = null;
		try {
			String query = "SELECT * FROM items";
			logger.error("in getAllItems: " + query);
			resultList = this.jdbcTemplate.queryForList(query);
		} catch (Exception e) {
			logger.error("Error in getAllItems: " + e.getMessage());
		}
		return resultList;
	}

	public boolean addItem(ItemsModel items) {
		try {
			logger.info("In add item method");
			String sql = "insert into items values (?, ?, ?, ?, ?, ?, ?, ?) ";
			logger.info("query=" + sql);
			this.jdbcTemplate.update(sql, new Object[] {items.getItemDisplayName(), items.getPrice(), items.getQuantity(), items.getStartTime(), items.getEndTime(), items.getLocation(), items.getDescription(), items.getSeller()}) ;
		} catch (Exception e) {
			logger.error("Error in addItem: " + e.getMessage());
		}

		return true;
	}
}