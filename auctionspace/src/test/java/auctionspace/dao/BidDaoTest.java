package auctionspace.dao;

import javax.sql.DataSource;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.auctionspace.dao.BidDao;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.model.BidModel;
import com.auctionspace.model.ItemsModel;

@ContextConfiguration(locations = "classpath:AuctionSpace-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class BidDaoTest 
{		ItemsModel product = new ItemsModel();

@Autowired
public BidDao bidDao;

@Autowired
DataSource dataSource;

@Autowired
JdbcTemplate jdbcTemplate;

@Autowired
private ItemsDao itemDao;

@Before
public void init(){
	product.setItemDisplayName("MockItem");
	product.setPrice(100);
	product.setDescription("MockDescription");
	product.setLocation("Charlotte");
	product.setQuantity(1);
	product.setDescription("description");
	product.setImagePath("/zyx.png");
	product.setSeller("MockUser");
	product.setStartTime("2017-04-13");
	product.setEndTime("2017-04-14");
	product.setStatus("Active");
	itemDao.addItem(product, "img_path.png");

	String json = itemDao.getAllItems();
	JSONArray items = new JSONArray(json);

	String qry = "Delete from Bid where item_id = '"+ Integer.parseInt(items.getJSONObject(0).get("itemId").toString())+"'";
	jdbcTemplate.update(qry);

}

@Test
@Rollback(true)
public void testAddBid()
{
	String json = itemDao.getAllItems();
	JSONArray items = new JSONArray(json);
	BidModel bid = new BidModel();
	bid.setbid_amount((float) 150.00);
	bid.setitem_id(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
	bid.setusername("MockUser");
	bidDao.addBid(bid);

	int noOfBids = bidDao.getNoOfBids(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
	Assert.assertEquals(1, noOfBids);
}

@Test
@Rollback(true)
public void testHighestBid(){

	String json = itemDao.getAllItems();
	JSONArray items = new JSONArray(json);
	BidModel bid = new BidModel();
	bid.setbid_amount((float) 150.00);
	bid.setitem_id(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
	bid.setusername("MockUser");
	bidDao.addBid(bid);

	BidModel bid1 = new BidModel();
	bid1.setbid_amount((float) 200.00);
	bid1.setitem_id(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
	bid1.setusername("MockUser");
	bidDao.addBid(bid1);

	float highestBid = bidDao.getHighestBid(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
	Assert.assertEquals(200,highestBid,0.01);
}

@Test
@Rollback(true)
public void testgetNoOfBids(){
	String json = itemDao.getAllItems();
	JSONArray items = new JSONArray(json);
	BidModel bid = new BidModel();
	bid.setbid_amount((float) 150.00);
	bid.setitem_id(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
	bid.setusername("MockUser");

	bidDao.addBid(bid);

	int noOfBids = bidDao.getNoOfBids(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
	Assert.assertEquals(1, noOfBids);   	

}
}