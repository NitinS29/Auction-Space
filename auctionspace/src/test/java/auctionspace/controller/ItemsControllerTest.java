package auctionspace.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
import com.auctionspace.controller.ItemsController;
import com.auctionspace.dao.AuctionDao;
import com.auctionspace.dao.BidDao;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.dao.ManageUsersDao;
import com.auctionspace.model.AuctionModel;
import com.auctionspace.model.ItemsModel;
import com.auctionspace.model.UserModel;
import com.auctionspace.utils.EmailUtils;
import static org.mockito.Mockito.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:AuctionSpace-servlet-test.xml" })
@WebAppConfiguration
public class ItemsControllerTest {

	@InjectMocks
	ItemsController itemsController;
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
	@Mock
	EmailUtils emailUtil;
	private MockMvc mockMvc;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(itemsController).build();
	}

	@Test
	public void testGetItemsList() throws Exception{
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new  MockHttpServletRequest();
		session = (MockHttpSession) request.getSession();
		this.mockMvc.perform(get("/Items/getItemsList")
				.session(session))
		.andExpect(status().isOk());
	}

	@Test
	public void testGetItemsListForUser() throws Exception{
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new  MockHttpServletRequest();
		session = (MockHttpSession) request.getSession();
		session.setAttribute("fname", "abc");
		this.mockMvc.perform(get("/Items/getItemsList/{fname}","abc")
				.session(session))
		.andExpect(status().isOk());
	}

	@Test
	public void testGetItemsAuctionedByUser() throws Exception{
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new  MockHttpServletRequest();
		session = (MockHttpSession) request.getSession();
		session.setAttribute("fname", "abc");
		this.mockMvc.perform(get("/Items/getItemsAuctionedByUser/{fname}","abc")
				.session(session))
		.andExpect(status().isOk());
	}

	@Test
	public void testGetItemsBoughtByUser() throws Exception{
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new  MockHttpServletRequest();
		session = (MockHttpSession) request.getSession();
		session.setAttribute("fname", "abc");
		this.mockMvc.perform(get("/Items/getItemsBoughtByUser/{fname}","abc")
				.session(session))
		.andExpect(status().isOk());
	}

	@Test
	public void testDisplayItems() throws Exception{
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new  MockHttpServletRequest();
		session = (MockHttpSession) request.getSession();
		session.setAttribute("fname", "abc");
		this.mockMvc.perform(get("/Items/displayItems/{fname}","abc")
				.session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("DisplayItems"));
	}

	@Test
	public void testDisplayAuctionedItems() throws Exception{
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new  MockHttpServletRequest();
		session = (MockHttpSession) request.getSession();
		session.setAttribute("fname", "abc");
		this.mockMvc.perform(get("/Items/displayAuctionedItems/{fname}","abc")
				.session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("AuctionedItems"));
	}

	@Test
	public void testAddItem() throws Exception{
		ItemsModel item = mock(ItemsModel.class); 
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new  MockHttpServletRequest();
		session = (MockHttpSession) request.getSession();
		session.setAttribute("item", item);
		this.mockMvc.perform(post("/Items/processAddItem")
				.session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("DisplayItems"));
	}

	@Test
	public void testShowRegister() throws Exception{
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new  MockHttpServletRequest();
		session = (MockHttpSession) request.getSession();
		session.setAttribute("user", "abc");
		this.mockMvc.perform(get("/Items/addItem/{user}", "abc")
				.session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("AddItems"));
	}

	@Test
	public void testGetItemInformation() throws Exception{
		MockHttpSession session = new MockHttpSession();
		MockHttpServletRequest request = new  MockHttpServletRequest();
		session = (MockHttpSession) request.getSession();
		session.setAttribute("fname", "abc");
		session.setAttribute("itemId", "1");
		this.mockMvc.perform(get("/Items/getItemInformation")
				.session(session))
		.andExpect(status().isOk())
		.andExpect(view().name("ItemInformation"));
	}
}
