package auctionspace.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.auctionspace.model.BidModel;

public class BidModelTest {
	BidModel bid = new BidModel(1,200,1,"snitin");

	@Test
	public final void testGetbid_id() {
		assertEquals(1,bid.getbid_id());
		assertNotEquals(4, bid.getbid_id());
	}

	@Test
	public final void testSetbid_id() {
		bid.setbid_id(2);
		assertEquals(bid.getbid_id(),2);
		assertNotEquals(bid.getbid_id(),4);
	}

	@Test
	public final void testGetbid_amount() {
		assertEquals(200,bid.getbid_amount(),0.01);
		assertNotEquals(0,bid.getbid_amount(),0.01);
	}

	@Test
	public final void testSetbid_amount() {
		bid.setbid_amount(250);
		assertEquals(bid.getbid_amount(),250,0.01);
		assertNotEquals(bid.getbid_amount(),0,0.01);		
	}

	@Test
	public final void testGetitem_id() {
		assertEquals(bid.getitem_id(),1);
		assertNotEquals(bid.getitem_id(),4);
	}

	@Test
	public final void testSetitem_id() {
		bid.setitem_id(5);
		assertEquals(bid.getitem_id(),5);
		assertNotEquals(bid.getitem_id(),1);
	}

	@Test
	public final void testGetusername() {
		assertEquals(bid.getusername(),"snitin");
		assertNotEquals(bid.getusername(),"snit1n");
	}

	@Test
	public final void testSetusername() {
		bid.setusername("Joe");
		assertEquals(bid.getusername(),"Joe");
		assertNotEquals(bid.getusername(),"nitin");
	}

}
