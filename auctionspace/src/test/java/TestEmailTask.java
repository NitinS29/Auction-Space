import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.auctionspace.utils.EmailTask;

@ContextConfiguration(locations = "classpath:AuctionSpace-servlet-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestEmailTask {

	@Test
	public void testSend() {
		EmailTask testEmail = new EmailTask();
		testEmail.sendMailToSellers();
	}
}