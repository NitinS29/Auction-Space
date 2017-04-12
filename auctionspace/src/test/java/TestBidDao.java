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
import com.auctionspace.dao.BidDao;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.model.AuctionModel;
import com.auctionspace.model.BidModel;
 
@ContextConfiguration(locations = "classpath:AuctionSpace-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestBidDao 
{
     
    @Autowired
    public BidDao bidService;

	@Autowired
	private ItemsDao itemService;
     
    @Test
    @Rollback(true)
    public void testAddBid()
    {
    	JSONArray items = itemService.getAllItems();
    	BidModel bid = new BidModel();
        bid.setbid_amount((float) 150.00);
        bid.setitem_id(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
        bid.setusername("mockUser");
        bidService.addBid(bid);
         
        int noOfBids = bidService.getNoOfBids(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
        Assert.assertEquals(1, noOfBids);
    }
}