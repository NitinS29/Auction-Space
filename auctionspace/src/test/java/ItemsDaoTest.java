package com.auctionspace.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import com.auctionspace.model.ItemsModel;

public class ItemsDaoTest {

	@Test
	public void testGetAllItems() {
		ItemsDao test = new ItemsDao();
		ItemsModel testProduct = new ItemsModel();
		test.addItem(testProduct);
		assertNotNull(test.getAllItems());
	}

	@Test
	public void testAddItem() {
		ItemsDao test = new ItemsDao();
		ItemsModel testProduct = new ItemsModel();
		assertTrue(test.addItem(testProduct));
	}

	@Test
	public void testGetItemDetails() {
		ItemsDao test = new ItemsDao();
		ItemsModel testProduct = new ItemsModel();
		testProduct.setItemId(56131);
		test.addItem(testProduct);
		assertNull(test.getItemDetails(String.valueOf(testProduct.getItemId())));
	}

}
