<<<<<<< HEAD
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
			logger.info("in clone info insert");
			String sql = "insert into items values (?, ?, ?, ?, ?, ?, ?) ";
			logger.info("query=" + sql);
			this.jdbcTemplate.update(sql, new Object[] {items.getItemDisplayName(), items.getPrice(), items.getQuantity(), items.getStartTime(), items.getEndTime(), items.getLocation(), items.getDescription()}) ;
		} catch (Exception e) {
			logger.error("Error in addItem: " + e.getMessage());
		}

		return true;
	}
}
=======
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
>>>>>>> 6d6b33cfddf381abd23af70fa95051383cf7896c
