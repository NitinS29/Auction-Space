package auctionspace.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.auctionspace.model.ItemsModel;

public class ItemsModelTest {
	ItemsModel item = new ItemsModel(1, "Test Product", 100, 1, "TestUser_0_test_product.jpg", "04/26/2017", 
			"04/29/2017", "TestUser", "Charlotte", "Test Product", "Active");

	@Test
	public void testGetItemId() {
		assertEquals(item.getItemId(), 1);
		assertNotEquals(item.getItemId(), 5);
	}

	@Test
	public void testGetItemDisplayName() {
		assertEquals(item.getItemDisplayName(), "Test Product");
		assertNotEquals(item.getItemDisplayName(), "TestProduct");
	}

	@Test
	public void testGetPrice() {
		assertEquals(item.getPrice(), 100, 1);
		assertNotEquals(item.getPrice(), 1000, 1);
	}

	@Test
	public void testGetQuantity() {
		assertNotEquals(item.getQuantity(), 3);
		assertEquals(item.getQuantity(), 1);
	}

	@Test
	public void testGetImagePath() {
		assertNotEquals(item.getImagePath(), "TestUser_0_test_product.png");
		assertEquals(item.getImagePath(), "TestUser_0_test_product.jpg");
	}

	@Test
	public void testGetStartTime() {
		assertNotEquals(item.getStartTime(), "04/25/2017");
		assertEquals(item.getStartTime(), "04/26/2017");
	}

	@Test
	public void testGetEndTime() {
		assertNotEquals(item.getEndTime(), "04/30/2017");
		assertEquals(item.getEndTime(), "04/29/2017");
	}

	@Test
	public void testGetDescription() {
		assertNotEquals(item.getDescription(), "TestProduct");
		assertEquals(item.getDescription(), "Test Product");
	}

	@Test
	public void testGetSeller() {
		assertNotEquals(item.getSeller(), "Test User");
		assertEquals(item.getSeller(), "TestUser");
	}

	@Test
	public void testGetLocation() {
		assertNotEquals(item.getLocation(), "North Carolina");
		assertEquals(item.getLocation(), "Charlotte");
	}

	@Test
	public void testGetStatus() {
		assertNotEquals(item.getStatus(), "Stopped");
		assertEquals(item.getStatus(), "Active");
	}

	@Test
	public void testSetItemId() {
		assertEquals(item.getItemId(), 1);
		assertNotEquals(item.getItemId(), 5);
	}

	@Test
	public void testSetItemDisplayName() {
		item.setItemDisplayName("TestProduct");
		assertEquals(item.getItemDisplayName(), "Test Product");
		assertNotEquals(item.getItemDisplayName(), "Test Product");
	}

	@Test
	public void testSetPrice() {
		item.setPrice(1000);
		assertNotEquals(item.getPrice(), 100, 1);
		assertEquals(item.getPrice(), 1000, 1);
	}

	@Test
	public void testSetQuantity() {
		item.setQuantity(3);
		assertEquals(item.getQuantity(), 3);
		assertNotEquals(item.getQuantity(), 1);
	}

	@Test
	public void testSetImagePath() {
		item.setImagePath("TestUser_0_test_product.png");
		assertEquals(item.getImagePath(), "TestUser_0_test_product.png");
		assertNotEquals(item.getImagePath(), "TestUser_0_test_product.jpg");
	}

	@Test
	public void testSetStartTime() {
		item.setStartTime("04/25/2017");
		assertEquals(item.getStartTime(), "04/25/2017");
		assertNotEquals(item.getStartTime(), "04/26/2017");
	}

	@Test
	public void testSetEndTime() {
		item.setEndTime("04/30/2017");
		assertEquals(item.getEndTime(), "04/30/2017");
		assertNotEquals(item.getEndTime(), "04/29/2017");
	}

	@Test
	public void testSetDescription() {
		item.setDescription("TestProduct");
		assertEquals(item.getDescription(), "TestProduct");
		assertNotEquals(item.getDescription(), "Test Product");
	}

	@Test
	public void testSetSeller() {
		item.setSeller("Test User");
		assertEquals(item.getSeller(), "Test User");
		assertNotEquals(item.getSeller(), "TestUser");
	}

	@Test
	public void testSetLocation() {
		item.setLocation("North Carolina");
		assertEquals(item.getLocation(), "North Carolina");
		assertNotEquals(item.getLocation(), "Charlotte");
	}

	@Test
	public void testSetStatus() {
		item.setStatus("Stopped");
		assertEquals(item.getStatus(), "Stopped");
		assertNotEquals(item.getStatus(), "Active");
	}
}
