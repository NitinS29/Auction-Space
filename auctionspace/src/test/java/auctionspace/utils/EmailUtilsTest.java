package auctionspace.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.auctionspace.model.ItemsModel;
import com.auctionspace.utils.EmailUtils;

@ContextConfiguration(locations = "classpath:AuctionSpace-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class EmailUtilsTest {

	@Test
	public void testSend() {
		ItemsModel testProduct = new ItemsModel();
		EmailUtils testEmail = new EmailUtils();
		testProduct.setItemDisplayName("TestProduct");
		testEmail.send("email.auctionspace@gmail.com", "mockItem", 100);
	}
}
