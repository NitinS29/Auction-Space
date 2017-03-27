package com.auctionspace.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class ItemsControllerTest1 {

	@Test
	public void testGetItemsList() {
		ItemsController test = new ItemsController();
		MockHttpServletRequest testRequest = new MockHttpServletRequest();
		assertNull("ItemsController is empty.", test.getItemsList());
		test.addItem(testRequest, "Item_1");
		assertNotNull("ItemsController is not empty.", test.getItemsList());
		test.addItem(testRequest, "Item_2");
		assertNotNull("ItemsController is not empty.", test.getItemsList());
	}

	@Test
	public void testAddItem() {
		MockHttpServletRequest testRequest = new MockHttpServletRequest();
		ItemsController test = new ItemsController();
		assertNull("ItemsController is empty.", test.getItemsList());
		test.addItem(testRequest, "Item1");
		assertSame("Item1", test.addItem(testRequest, "Item1")) ;
		assertNotNull("ItemsController is not empty.", test.getItemsList());
		test.getItemsList();
		test.addItem(testRequest, "Item2");
		assertSame("Item2", test.addItem(testRequest, "Item2")) ;
		assertNotNull("ItemsController is not empty.", test.getItemsList());
		test.getItemsList();
	}

	@Test
	public void testSayHello() {
		ItemsController test = new ItemsController();
		assertSame("helloWorld", test.sayHello()) ;
	}

}
