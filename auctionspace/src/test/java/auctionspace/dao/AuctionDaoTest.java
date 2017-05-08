package auctionspace.dao;
import java.util.List;

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
import org.springframework.transaction.annotation.Transactional;

import com.auctionspace.dao.AuctionDao;
import com.auctionspace.dao.ItemsDao;
//import com.auctionspace.dao.ItemsDao.ItemMapper;
import com.auctionspace.model.AuctionModel;
import com.auctionspace.model.ItemsModel;
 
@ContextConfiguration(locations = "classpath:AuctionSpace-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AuctionDaoTest 
{
	ItemsModel product = new ItemsModel();
     
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
    @Autowired
    private AuctionDao auctionService;
     
	@Autowired
	private ItemsDao itemService;
	
	@Autowired
	private ItemsModel item;
	
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
		
    	//JSONArray items = itemService.getAllItems();
		String qry = "Delete from Registered_Users";
		jdbcTemplate.update(qry);

    		
	}
	
    @Test
    @Rollback(true)
    public void testRegisterUser()
    {
    	JSONArray items = itemService.getAllItems();
    	AuctionModel auction = new AuctionModel();
        auction.setItemId(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
        auction.setFname("Mock");
        auction.setEmailId("email.auctionspace@gmail.com");
        auctionService.registerUser(auction);
         
        List<AuctionModel> auctions = auctionService.getAllRegisteredUsers();
        Assert.assertEquals(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()), auctions.get(0).getItemId());
        Assert.assertEquals(auction.getEmailId(), auctions.get(0).getEmailId());
        Assert.assertEquals(auction.getFname(), auctions.get(0).getFname());
    }
    
    @Test
    @Rollback(true)
    public void testgetAllRegisteredUsers()
    {
    	JSONArray items = itemService.getAllItems();
    	AuctionModel auction = new AuctionModel();
        auction.setItemId(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
        auction.setFname("Mock");
        auction.setEmailId("email.auctionspace@gmail.com");
        auctionService.registerUser(auction);
        
        List<AuctionModel> auctions = auctionService.getAllRegisteredUsers();
        Assert.assertNotEquals(0, auctions.size());
        
    }
    
    @Test
    @Rollback(true)
    public void testStopAuction()
    {
    	JSONArray items = itemService.getAllItems();
    	AuctionModel auction = new AuctionModel();
        auction.setItemId(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
        auction.setFname("Mock");
        auction.setEmailId("email.auctionspace@gmail.com");
        auctionService.stopAuction(auction.getItemId());
     
        item = itemService.getItemDetails(items.getJSONObject(0).get("itemId").toString());
        //JSONArray item = itemService.getAllItems();
        Assert.assertEquals("Stopped", item.getStatus());
    }
}