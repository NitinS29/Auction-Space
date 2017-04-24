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
import com.auctionspace.model.ItemsModel;

@Service
public class AuctionDao {
	@Autowired
	DataSource dataSource;

	@Autowired 
	JdbcTemplate jdbcTemplate;

	private static Logger logger = Logger.getLogger(AuctionDao.class);

	class AuctionMapper implements RowMapper<AuctionModel> {
		public AuctionModel mapRow(ResultSet rs, int arg1) throws SQLException {
			AuctionModel auction = new AuctionModel();
			auction.setItemId((int)rs.getInt("item_id"));
			auction.setFname(rs.getString("fname"));
			auction.setEmailId(rs.getString("emailId"));
			return auction;
		}
	}

	public void registerUser(AuctionModel auction) {
		try {
			logger.info("In register user for auction of an item method");
			logger.debug("log " + auction.getItemId() + auction.getFname() + auction.getEmailId());
			String sql = "insert into Registered_Users (item_id, fname, emailId) values (?, ?, ?) ";
			logger.info("query=" + sql);
			this.jdbcTemplate.update(sql, new Object[] {auction.getItemId(), auction.getFname(), auction.getEmailId()}) ;
		} catch (Exception e) {
			logger.error("Error in registerUser: " + e.getMessage());
		}
	}

	public List<AuctionModel> getAllRegisteredUsers() {
		List<AuctionModel> registeredUsers = null;
		try {
			String sql = "select * from Registered_Users";
			logger.info("query=" + sql);
			registeredUsers = this.jdbcTemplate.query(sql, new AuctionMapper());
		} catch (Exception e) {
			logger.error("Error in registerUser: " + e.getMessage());
		}	
		return registeredUsers;
	}
	
	public boolean stopAuction(int itemId) {
		try {
			logger.info("In stop auction method");
			String sql = "update items set status='Stopped' where item_id = ?";
			logger.info("query=" + sql);
			this.jdbcTemplate.update(sql, new Object[] {itemId}) ;
		} catch (Exception e) {
			logger.error("Error in addItem: " + e.getMessage());
		}
		return true;
	}
}