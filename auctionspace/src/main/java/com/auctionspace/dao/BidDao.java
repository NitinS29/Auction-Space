package com.auctionspace.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.auctionspace.model.BidModel;
import com.auctionspace.model.UserModel;
//import com.auctionspace.utils.ItemUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

@Service
public class BidDao {
	@Autowired
	DataSource dataSource ;//= ConnectionUtility.getDataSource();
	@Autowired
	JdbcTemplate jdbcTemplate ;//= new JdbcTemplate(dataSource);

	public static BidDao instance = new BidDao();
	private static Logger logger = Logger.getLogger(BidDao.class);

	public static BidDao getInstance() {
		return instance;}
	
	public float getLastBid(int item_id){
		float prevBid = 0;
		try {
			String query = "SELECT MAX(bid_amount) FROM Bid where item_id = ?";
			logger.info("in getPreviousBid: " + query);
			prevBid = jdbcTemplate.queryForObject(query, new Object[] {item_id}, float.class);//   this.jdbcTemplate.queryForList(query);
		} catch (Exception e) {
		    ItemsDao itemsDao = new ItemsDao();
			prevBid = itemsDao.getItemPrice(item_id);
			logger.error("Error in getPrevBid: " + e.getMessage());
		}
		return prevBid;
	}
	
	public int getNoOfBids(int item_id){
		int noOfBids = 0;
		try {
			String query = "SELECT COUNT(bid_amount) FROM Bid where item_id = ?";
			logger.info("in getNoOfBids: " + query);
			noOfBids = jdbcTemplate.queryForObject(query, new Object[] {item_id},int.class);//   this.jdbcTemplate.queryForList(query);
		} catch (Exception e) {
		    //ItemsDao itemsDao = new ItemsDao();
		    //noOfBids = itemsDao.getItemPrice(item_id);
			logger.error("Error in getNoOfBids: " + e.getMessage());
		}
		return noOfBids;
	}
	
	public boolean addBid(BidModel bid) {
		try {
			logger.info("In add bid method");
			String sql = "insert into Bid(bid_amount,username,item_id) values ( ?, ?, ?) ";
			logger.info("query=" + sql);
			jdbcTemplate.update(sql, new Object[] {bid.getbid_amount(), bid.getusername(), bid.getitem_id()}) ;
		} catch (Exception e) {
			logger.error("Error in addBid: " + e.getMessage());
		}

		return true;
	}
	
}
	class BidMapper implements RowMapper<BidModel> {
		public BidModel mapRow(ResultSet rs, int arg1) throws SQLException {
		  BidModel bid = new BidModel();
		  bid.setbid_id(rs.getInt("bid_id"));
		  bid.setbid_amount(rs.getFloat("bid_amount"));
		  bid.setitem_id(rs.getInt("item_id"));
		  bid.setusername(rs.getString("username"));
		  return bid;
		}
}
