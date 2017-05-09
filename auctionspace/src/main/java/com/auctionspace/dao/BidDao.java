package com.auctionspace.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.auctionspace.model.BidModel;
import com.auctionspace.utils.ConnectionUtility;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

@Service
public class BidDao {
	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	BidDao() {
		dataSource= ConnectionUtility.getDataSource();
		jdbcTemplate= new JdbcTemplate(dataSource);
	}
	
	public static BidDao instance = new BidDao();
	private static Logger logger = Logger.getLogger(BidDao.class);

	public static BidDao getInstance() {
		return instance;
	}

	public float getHighestBid(int item_id){
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

	public BidModel getWinningBid(int itemId) {
		BidModel bid = null;
		try {
			String query = "select b.item_id, b.bid_id, b.username, b.bid_amount from items as i, bid as b "
					+ "where b.bid_amount = ( select max(bid_amount) from bid group by item_id having item_id='" + itemId 
					+ "') and b.item_id = i.item_id and i.item_id='" + itemId + "' and i.status = 'Closed'";
			logger.info("in getWinningBid: " + query);
			bid = jdbcTemplate.queryForObject(query,  new BidMapper());
		} catch (Exception e) {
			logger.error("Error in getWinningBid: " + e.getMessage());
		}
		return bid;
	}

	public List<Integer> getListOfClosedBids() {
		List<Map<String, Object>> listOfClosedBids = null;
		List<Integer> listOfItemIdClosedBids = new ArrayList<Integer>();
		try {
			String query = "select b.item_id from bid as b, items as i where i.item_id = b.item_id and i.sent_mail = 0 and i.status = 'Closed' and i.end_time + interval 1 day = curdate()";
			logger.info("in getListOfClosedBids: " + query);
			listOfClosedBids = jdbcTemplate.queryForList(query);
			for(int i = 0; i < listOfClosedBids.size(); i++) {
				listOfItemIdClosedBids.add((int)listOfClosedBids.get(i).get("item_id"));
			}
		} catch (Exception e) {
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();
			logger.error("Error in getListOfClosedBids" + exceptionAsString);
		}
		return listOfItemIdClosedBids;
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
