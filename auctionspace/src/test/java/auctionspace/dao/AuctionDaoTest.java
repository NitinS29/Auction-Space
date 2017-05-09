package auctionspace.dao;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.auctionspace.dao.AuctionDao;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.model.AuctionModel;

@ContextConfiguration(locations = "classpath:AuctionSpace-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AuctionDaoTest 
{

	@Autowired
	private AuctionDao auctionDao;

	@Autowired
	private ItemsDao itemDao;

	@Autowired 
	JdbcTemplate jdbcTemplate;
	
	@Test
	@Rollback(true)
	public void testRegisterUser()
	{
		String json = itemDao.getAllItems();
		JSONArray items = new JSONArray(json);
		AuctionModel auction = new AuctionModel();
		auction.setItemId(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()));
		auction.setFname("Mock");
		auction.setEmailId("email.auctionspace@gmail.com");
		auctionDao.registerUser(auction);

		String sql = "select * from Registered_Users";
		List<Map<String, Object>> registeredUsers = this.jdbcTemplate.queryForList(sql);
		Assert.assertEquals(Integer.parseInt(items.getJSONObject(0).get("itemId").toString()), registeredUsers.get(0).get("item_id"));
		Assert.assertEquals(auction.getEmailId(), registeredUsers.get(0).get("emailId").toString());
		Assert.assertEquals(auction.getFname(), registeredUsers.get(0).get("fname").toString());
	}
	
	@Test
	public void testStopAuction() {
		auctionDao.stopAuction(1);
		String sql = "select * from items where item_id = '1'";
		List<Map<String, Object>> items = this.jdbcTemplate.queryForList(sql);
		Assert.assertEquals(items.get(0).get("status").toString(), "Stopped");
	}
	
	@Test
	public void testGetAllRegisteredUsers() {
		List<AuctionModel> rUsers = auctionDao.getAllRegisteredUsers();
		String sql = "select * from Registered_Users";
		List<Map<String, Object>> registeredUsers = this.jdbcTemplate.queryForList(sql);
		Assert.assertEquals(registeredUsers.size(), rUsers.size());
	}
}