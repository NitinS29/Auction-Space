import static org.junit.Assert.*;

import java.util.List;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.auctionspace.dao.ItemsDao;
import com.auctionspace.model.ItemsModel;

@ContextConfiguration(locations = "classpath:AuctionSpace-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestItemsDao {

	@Autowired
	private ItemsDao itemService;

	@Test
	@Rollback(true)
	public void testAddItem() {
		ItemsModel product = new ItemsModel();
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
		itemService.addItem(product, "img_path.png");

		JSONArray items = itemService.getAllItems();
		Assert.assertEquals(1, items.length());
		Assert.assertEquals(product.getItemDisplayName(), items.getJSONObject(0).get("itemDisplayName"));
		Assert.assertEquals(product.getLocation(), items.getJSONObject(0).get("location"));
		Assert.assertEquals(product.getSeller(), items.getJSONObject(0).get("seller"));
	}
}
