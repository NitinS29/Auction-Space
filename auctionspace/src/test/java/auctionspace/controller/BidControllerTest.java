package auctionspace.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.auctionspace.controller.BidController;
import com.auctionspace.dao.BidDao;
import com.auctionspace.dao.ItemsDao;
import com.auctionspace.dao.ManageUsersDao;
import com.auctionspace.model.BidModel;
import com.auctionspace.model.UserModel;
import com.auctionspace.utils.BidUtils;
import com.auctionspace.utils.EmailUtils;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration({ "classpath:AuctionSpace-servlet-test.xml" })
@WebAppConfiguration
public class BidControllerTest {


	@InjectMocks
	BidController bidController;
	@Mock
	UserModel userInfo;

	@Mock
	BidDao bidDao;
	@Mock
	BidModel bidModel;
	@Mock
	BidUtils bidUtil;
	@Mock
	public ItemsDao itemDao;
	@Mock
	ManageUsersDao userDao;
	@Mock
	EmailUtils emailUtil;
	private MockMvc mockMvc;

	public ManageUsersDao userDao(){
		return Mockito.mock(ManageUsersDao.class);
	}

	@Before
	public void setup(){
		//bidController = new BidController();
		MockitoAnnotations.initMocks(this);
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jsp");
		this.mockMvc = MockMvcBuilders.standaloneSetup(bidController).setViewResolvers(viewResolver).build();

		userInfo = userDao.getUserDetails("MockUser");	
	}


	@Test
	public void testgetBid() throws Exception{
		Map<String, Object> sessionAttrs = new HashMap<>();
		sessionAttrs.put("userId", "Nitin");

		this.mockMvc.perform(get("/Bid/bidding/{itemId}",1).sessionAttrs(sessionAttrs))
		.andExpect(model().attribute("user","Nitin"))
		.andExpect(status().isOk())
		.andExpect(view().name("Bid"));

	}

	@Test
	public void testSetBid() throws Exception{
		this.mockMvc.perform(post("/Bid/bidProcess/{itemId}", 27))
		.andExpect(model().attribute("message", "Bid is invalid!!"))
		.andExpect(status().isOk())
		.andExpect(view().name("ItemInformation"));

	}

}
