import java.util.List;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.auctionspace.dao.AuctionDao;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.model.AuctionModel;
 
@ContextConfiguration(locations = "classpath:AuctionSpace-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAuctionDao 
{
     
    @Autowired
    private AuctionDao auctionService;
     
	@Autowired
	private ItemsDao itemService;
	
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
}