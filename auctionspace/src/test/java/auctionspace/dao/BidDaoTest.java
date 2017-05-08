package auctionspace.dao;

import javax.sql.DataSource;

import org.aspectj.lang.annotation.After;
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
    public BidDao bidService;
    
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	private ItemsDao itemService;
     
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
		itemService.addItem(product, "img_path.png");
		
    	JSONArray items = itemService.getAllItems();
    	
    		String qry = "Delete from Bid where item_id = '"+ Integer.parseInt(items.getJSONObject(0).get("itemId").toString())+"'";
    		jdbcTemplate.update(qry);
    		
	}
	
    @Test
    @Rollback(true)
    public void testAddBid()
    {
    	JSONArray items = itemService.getAllItems();
    	BidModel bid = new BidModel();
        bid.setbid_amount((float) 150.00);
        bid.setitem_id(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
        bid.setusername("MockUser");
        bidService.addBid(bid);
         
        int noOfBids = bidService.getNoOfBids(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
        Assert.assertEquals(1, noOfBids);
    }
       
    @Test
    @Rollback(true)
    public void testHighestBid(){
    	
    	JSONArray items = itemService.getAllItems();
    	BidModel bid = new BidModel();
        bid.setbid_amount((float) 150.00);
        bid.setitem_id(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
        bid.setusername("MockUser");
        bidService.addBid(bid);
        
    	BidModel bid1 = new BidModel();
        bid1.setbid_amount((float) 200.00);
        bid1.setitem_id(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
        bid1.setusername("MockUser");
        bidService.addBid(bid1);
        
        float highestBid = bidService.getHighestBid(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
        Assert.assertEquals(200,highestBid,0.01);
    }
    
    @Test
    @Rollback(true)
    public void testgetNoOfBids(){
       	JSONArray items = itemService.getAllItems();
    	BidModel bid = new BidModel();
        bid.setbid_amount((float) 150.00);
        bid.setitem_id(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
        bid.setusername("MockUser");
        
        bidService.addBid(bid);
        
        int noOfBids = bidService.getNoOfBids(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
        Assert.assertEquals(1, noOfBids);   	
    	
    }
}