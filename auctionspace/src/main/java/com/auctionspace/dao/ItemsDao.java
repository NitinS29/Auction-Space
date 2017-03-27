package com.auctionspace.dao;

import java.sql.SQLException;
import org.apache.log4j.Logger;
//import org.json.JSONArray;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ItemsDao {
	Connection conUtility = ConnectionUtility.getConnection();
	public static ItemsDao instance = new ItemsDao();
	private static Logger logger = Logger.getLogger(ItemsDao.class);

	public static ItemsDao getInstance() {
		return instance;
	}

	public ResultSet getAllItems() {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conUtility.createStatement();
			String query = "SELECT * FROM items";
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			logger.error("Error in getAllItems: " + e.getMessage());
		}
		return resultSet;
	}
	
	public ResultSet addItem() {
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = conUtility.createStatement();
			String query = "insert into items values(1, 'random', 89.9, 1, 3, '2017-03-27', '2017-03-21', 'XYZ', 'Charlotte', 100.0, 'Item Description');";
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			logger.error("Error in addItem: " + e.getMessage());
		}
		return resultSet;
	}
}
