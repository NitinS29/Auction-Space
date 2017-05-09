package auctionspace.dao;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.auctionspace.dao.ItemsDao;
import com.auctionspace.model.ItemsModel;

@ContextConfiguration(locations = "classpath:AuctionSpace-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemsDaoTest {

	@Autowired
	private ItemsDao itemDao;
	@Autowired 
	JdbcTemplate jdbcTemplate;

	@Test
	@Rollback(true)
	public void testAddItem() {
		String query = "select * from Items";
		List<Map<String, Object>> itemsList = this.jdbcTemplate.queryForList(query);
		int iSize = itemsList.size();

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
		itemDao.addItem(product, "img_path.png");

		JSONArray items = new JSONArray();
		int aSize = 0;
		try {
			query = "select * from Items";
			itemsList = this.jdbcTemplate.queryForList(query);
			aSize = itemsList.size();
			for (int i = 0; i < itemsList.size(); i++)
			{
				JSONObject item = new JSONObject();
				item.put("itemId", itemsList.get(i).get("item_id").toString());
				item.put("itemDisplayName", itemsList.get(i).get("item_display_name").toString());
				item.put("price", (float) itemsList.get(i).get("price"));
				item.put("quantity", (int) itemsList.get(i).get("quantity"));
				item.put("startTime", itemsList.get(i).get("start_time").toString());
				item.put("endTime", itemsList.get(i).get("end_time").toString());
				item.put("seller", itemsList.get(i).get("seller").toString());
				item.put("location", itemsList.get(i).get("location").toString());
				item.put("description", itemsList.get(i).get("description").toString());
				item.put("imagePath", itemsList.get(i).get("image_path").toString());
				items.put(item);
			}
		} catch (Exception e) {
		}

		Assert.assertEquals(aSize, iSize+1);
		Assert.assertEquals(product.getItemDisplayName(), items.getJSONObject(0).get("itemDisplayName"));
		Assert.assertEquals(product.getLocation(), items.getJSONObject(0).get("location"));
		Assert.assertEquals(product.getSeller(), items.getJSONObject(0).get("seller"));
	}

	@Test
	@Rollback(true)
	public void testGetAllItems() {
		String json = itemDao.getAllItems();
		JSONArray items = new JSONArray(json);

		String sql = "select * from items";
		List<Map<String, Object>> itemsList = this.jdbcTemplate.queryForList(sql);
		Assert.assertEquals(items.length(), itemsList.size());
	}

	@Test
	@Rollback(true)
	public void testGetItemDetails() {
		ItemsModel item = itemDao.getItemDetails("1");

		String query = "select * from Items where item_id = 1";
		List<Map<String, Object>> itemsList = this.jdbcTemplate.queryForList(query);
		//Assert.assertEquals(item.getItemDisplayName(), itemsList.get(0).get("itemDisplayName").toString());
		//Assert.assertEquals(item.getLocation(), itemsList.get(0).get("location").toString());
		Assert.assertEquals(item.getSeller(), itemsList.get(0).get("seller").toString());
	}

	@Test
	@Rollback(true)
	public void testGetSeller() {
		String seller = itemDao.getSeller(1);

		String query = "SELECT seller FROM Items where item_id = 1";
		List<Map<String, Object>> itemsList = this.jdbcTemplate.queryForList(query);
		Assert.assertEquals(seller, itemsList.get(0).get("seller").toString());
	}


	@Test
	@Rollback(true)
	public void testGetAllItemsForUser() {
		String json = itemDao.getAllItemsForUser("MockUser");
		JSONArray items = new JSONArray(json);

		String query = "select * from Items where status = 'Active' and seller NOT LIKE '%Mock%'";
		List<Map<String, Object>> itemsList = this.jdbcTemplate.queryForList(query);
		Assert.assertEquals(items.length(), itemsList.size());
	}

	@Test
	@Rollback(true)
	public void testGetItemsAuctionedByUser() {
		String json = itemDao.getItemsAuctionedByUser("MockUser");
		JSONArray items = new JSONArray(json);

		String query = "select * from Items where seller LIKE '%Mock%'";
		List<Map<String, Object>> itemsList = this.jdbcTemplate.queryForList(query);
		Assert.assertEquals(items.length(), itemsList.size());
	}
}
