package com.auctionspace.controller;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.auctionspace.model.LoginModel;
import com.auctionspace.model.UserModel;

public class ManageUsersControllerTest {

	@Test
	public void testGetDummyEmployee() {
		ManageUsersController test = new ManageUsersController();
		ModelAndView testModel = new ModelAndView();
		assertSame("index",test.getDummyEmployee(testModel));
	}

	@Test
	public void testShowRegister() {
		MockHttpServletRequest testReq = new MockHttpServletRequest();
		MockHttpServletResponse testRes = new MockHttpServletResponse();
		ManageUsersController test = new ManageUsersController();
		test.showRegister(testReq,testRes);
		assertNotNull(test.showRegister(testReq,testRes));
		assertSame("SellerRegister",test.showRegister(testReq,testRes));
	}

	@Test
	public void testAddUser() {
		MockHttpServletRequest testReq = new MockHttpServletRequest();
		MockHttpServletResponse testRes = new MockHttpServletResponse();
		ManageUsersController test = new ManageUsersController();
		UserModel dummyOne = new UserModel();
		assertNull(test.addUser(testReq, testRes, dummyOne));
		test.addUser(testReq, testRes, dummyOne);
		assertNotNull(test.addUser(testReq, testRes, dummyOne));
	}

	@Test
	public void testShowRegisterBuyer() {
		MockHttpServletRequest testReq = new MockHttpServletRequest();
		MockHttpServletResponse testRes = new MockHttpServletResponse();
		ManageUsersController test = new ManageUsersController();
		assertNull(test.showRegisterBuyer(testReq,testRes));
		test.showRegisterBuyer(testReq,testRes);
		assertNotNull(test.showRegisterBuyer(testReq,testRes));
		assertSame("BuyerRegister",test.showRegisterBuyer(testReq,testRes));
	}

	@Test
	public void testAddBuyer() {
		MockHttpServletRequest testReq = new MockHttpServletRequest();
		MockHttpServletResponse testRes = new MockHttpServletResponse();
		ManageUsersController test = new ManageUsersController();
		UserModel dummyOne = new UserModel();
		assertNull(test.addBuyer(testReq, testRes, dummyOne));
		test.addBuyer(testReq, testRes, dummyOne);
		assertNotNull(test.addBuyer(testReq, testRes, dummyOne));
	}

	@Test
	public void testShowLogin() {
		MockHttpServletRequest testReq = new MockHttpServletRequest();
		MockHttpServletResponse testRes = new MockHttpServletResponse();
		ManageUsersController test = new ManageUsersController();
		assertNull(test.showLogin(testReq, testRes));
		test.showLogin(testReq, testRes);
		assertNotNull(test.showLogin(testReq, testRes));
	}

	@Test
	public void testLoginProcess() {
		MockHttpServletRequest testReq = new MockHttpServletRequest();
		MockHttpServletResponse testRes = new MockHttpServletResponse();
		ManageUsersController test = new ManageUsersController();
		LoginModel testLogMod = new LoginModel();
		assertNull(test.loginProcess(testReq, testRes,testLogMod));
		test.loginProcess(testReq, testRes,testLogMod);
		assertNotNull(test.loginProcess(testReq, testRes,testLogMod));
	}

}
