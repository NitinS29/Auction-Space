/**
 * 
 */
package auctionspace.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.auctionspace.model.LoginModel;

public class LoginModelTest {
	LoginModel login = new LoginModel();
	LoginModel login1 = new LoginModel("snitin","secret");

	@Test
	public final void testLoginModel() {
		assertEquals(login.getUsername(),null);
		assertEquals(login.getPassword(),null);
		assertNotEquals(login.getUsername(),"abc");
		assertNotEquals(login.getPassword(),"xyz");
	}

	@Test
	public final void testLoginModelStringString() {
		assertEquals(login1.getUsername(),"snitin");
		assertEquals(login1.getPassword(),"secret");	
		assertNotEquals(login1.getUsername(),"");
		assertNotEquals(login1.getPassword(),"");
	}

	@Test
	public final void testGetUsername() {
		assertEquals("snitin",login1.getUsername());
		assertNotEquals("snitinss",login1.getUsername());
	}
	
	@Test
	public final void testSetUsername() {
		login.setUsername("Joe");
		assertEquals(login.getUsername(),"Joe");	
		assertNotEquals(login.getUsername(),"");
	}

	@Test
	public final void testSetPassword() {
		login.setPassword("mypwd");
		assertEquals(login.getPassword(),"mypwd");	
		assertNotEquals(login.getPassword(),"");
	}

	@Test
	public final void testGetPassword() {
		assertEquals("secret",login1.getPassword());
		assertNotEquals("sss",login1.getPassword());		
	}

}
