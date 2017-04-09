package com.auctionspace.utils;

import static org.junit.Assert.*;

import org.junit.Test;

import com.auctionspace.model.ItemsModel;

public class EmailUtilsTest {

	@Test
	public void testSend() {
		ItemsModel testProduct = new ItemsModel();
		EmailUtils testEmail = new EmailUtils();
		testProduct.setItemDisplayName("TestProduct");
		testEmail.send("email.auctionspace@gmail.com", testProduct);
	}

}
