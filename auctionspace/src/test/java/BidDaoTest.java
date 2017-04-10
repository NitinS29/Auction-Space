package com.auctionspace.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.auctionspace.model.BidModel;

public class BidDaoTest {

	@Test
	public void testGetInstance() {
		BidDao test = new BidDao();
		assertNotNull(BidDao.getInstance());
	}

	@Test
	public void testGetLastBid() {
		BidDao test = new BidDao();
		assertEquals(0,test.getLastBid(00000),0);
	}

	@Test
	public void testGetNoOfBids() {
		BidDao test = new BidDao();
		assertEquals(0,test.getNoOfBids(00000),0);		
	}

	@Test
	public void testAddBid() {
		BidDao test = new BidDao();
		BidModel testBid = new BidModel();
		assertTrue(test.addBid(testBid));
	}

}
