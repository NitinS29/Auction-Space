package auctionspace.model;

import static org.junit.Assert.*;

import org.junit.Test;
import com.auctionspace.model.AuctionModel;

public class AuctionModelTest {
	AuctionModel auction = new AuctionModel(1, "Test User", "email.auctionspace@gmail.com");

	@Test
	public void testGetItemId() {
		assertEquals(auction.getItemId(), 1);
		assertNotEquals(auction.getItemId(), 4);
	}
	
	@Test
	public void testGetFname() {
		assertEquals(auction.getFname(), "Test User");
		assertNotEquals(auction.getFname(), "TestUser");
	}
	
	@Test
	public void testGetEmailId() {
		assertEquals(auction.getEmailId(), "email.auctionspace@gmail.com");
		assertNotEquals(auction.getEmailId(), "email@gmail.com");
	}
	
	@Test
	public void testSetItemId() {
		auction.setItemId(4);
		assertNotEquals(auction.getItemId(), 1);
		assertEquals(auction.getItemId(), 4);
	}
	
	@Test
	public void testSetFname() {
		auction.setFname("TestUser");
		assertNotEquals(auction.getFname(), "Test User");
		assertEquals(auction.getFname(), "TestUser");
	}
	
	@Test
	public void testSetEmailId() {
		auction.setEmailId("email@gmail.com");
		assertEquals(auction.getEmailId(), "email@gmail.com");
		assertNotEquals(auction.getEmailId(), "email.auctionspace@gmail.com");
	}
}