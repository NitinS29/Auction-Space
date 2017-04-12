import org.junit.Test;

import com.auctionspace.model.ItemsModel;
import com.auctionspace.utils.EmailUtils;

public class EmailUtilsTest {

	@Test
	public void testSend() {
		ItemsModel testProduct = new ItemsModel();
		EmailUtils testEmail = new EmailUtils();
		testProduct.setItemDisplayName("TestProduct");
		testEmail.send("email.auctionspace@gmail.com", "mockItem", 100);
	}

}
