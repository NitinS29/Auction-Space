package auctionspace.controller;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import com.auctionspace.controller.ManageUsersController;
import com.auctionspace.dao.ManageUsersDao;
import com.auctionspace.model.UserModel;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:AuctionSpace-servlet-test.xml" })
@WebAppConfiguration
public class ManageUsersControllerTest {

	@InjectMocks
	ManageUsersController manageUsersController;
	@Autowired
	public ManageUsersDao userService;

	@Mock
	MockHttpSession session;
	@Mock 
	UserModel user;

	public ManageUsersDao userService(){
		return Mockito.mock(ManageUsersDao.class);
	}

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
		test.showRegisterUser(testReq,testRes);
		assertNotNull(test.showRegisterUser(testReq,testRes));
	}

	@Test
	public void testShowLogin() {
		MockHttpServletRequest testReq = new MockHttpServletRequest();
		MockHttpServletResponse testRes = new MockHttpServletResponse();
		ManageUsersController test = new ManageUsersController();
		assertNotNull(test.showLogin(testReq, testRes));
	}

}
