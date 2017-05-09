package auctionspace.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.web.WebAppConfiguration;

import com.auctionspace.controller.AuctionController;
import com.auctionspace.dao.AuctionDao;
import com.auctionspace.dao.BidDao;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.dao.ManageUsersDao;
import com.auctionspace.model.AuctionModel;
import com.auctionspace.model.ItemsModel;
import com.auctionspace.model.UserModel;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:AuctionSpace-servlet-test.xml" })
@WebAppConfiguration
public class AuctionControllerTest {

	@InjectMocks
	public AuctionController auctionController;
	@Mock
	public UserModel user;
	@Mock 
	public BidDao bidDao;
	@Mock
	public AuctionModel auctionModel;
	@Mock
	public ItemsModel itemsModel;
	@Mock
	public ItemsDao itemDao;
	@Mock
	public ManageUsersDao userDao;
	@Mock
	public AuctionDao auctionDao;

	private MockMvc mockMvc;


	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(auctionController).build();
	}

	@Test
	public void testGetAllAuctionInfo() throws Exception{
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new  MockHttpServletRequest();
		session = (MockHttpSession) request.getSession();
		session.setAttribute("fname", "ShipraShinde");
		this.mockMvc.perform(get("/Auction/getAllAuctions/{fname}","ShipraShinde")
				.session(session))
		.andExpect(status().isOk());
	}

	@Test
	public void testRegisterUserforItemAuction() throws Exception{
		AuctionModel auction = mock(AuctionModel.class);
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new  MockHttpServletRequest();
		session = (MockHttpSession) request.getSession();
		session.setAttribute("userId", "abc");
		session.setAttribute("auction", auction);
		this.mockMvc.perform(post("/Auction/registerUserforItemAuction")
				.session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("ItemInformation"));
	}

	@Test
	public void testGetItemInformation() throws Exception{
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new  MockHttpServletRequest();
		session = (MockHttpSession) request.getSession();
		session.setAttribute("itemId", "1");
		session.setAttribute("fname", "abc");
		this.mockMvc.perform(get("/Auction/getItemInfo")
				.session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("ItemInformation"));
	}
	
	@Test
	public void testDisplayItemsAdmin() throws Exception{
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new  MockHttpServletRequest();
		session = (MockHttpSession) request.getSession();
		session.setAttribute("fname", "abc");
		this.mockMvc.perform(get("/Auction/displayItemsAdmin/{fname}","abc")
				.session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("AllAuctionInfo"));
	}
}
