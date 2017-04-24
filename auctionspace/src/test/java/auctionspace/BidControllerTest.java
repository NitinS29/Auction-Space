package auctionspace;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import com.auctionspace.controller.BidController;

public class BidControllerTest {

		@Test
		public void testgetBid(){
			BidController test = new BidController();
			ModelAndView testModel = new ModelAndView();
			MockHttpServletRequest testReq = new MockHttpServletRequest();
			MockHttpServletResponse testRes = new MockHttpServletResponse();
			//assertSame("index",test.getBid("2", testReq, testRes, testModel));
		}
}
