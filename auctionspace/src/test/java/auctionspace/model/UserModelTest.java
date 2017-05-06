package auctionspace.model;

import static org.junit.Assert.*;

import org.junit.Test;

import com.auctionspace.model.UserModel;

public class UserModelTest {

	UserModel user = new UserModel("NitinS29", "secret", "Nitin","Salvankar","", "email.test@gmail.com", 980785437, "Charlotte");
	UserModel user1 = new UserModel();
	
	@Test
	public final void testGetUsername() {
		assertEquals("NitinS29",user.getUsername());
		assertNotEquals("Nitin",user.getUsername());
	}

	@Test
	public final void testSetUsername() {
		user1.setUsername("Joe");
		assertEquals("Joe",user1.getUsername());
		assertNotEquals("Nitin",user1.getUsername());
	}

	@Test
	public final void testGetPassword() {
		assertEquals("secret",user.getPassword());
		assertNotEquals("",user.getPassword());
	}

	@Test
	public final void testSetPassword() {
		user1.setPassword("mypassword");
		assertEquals("mypassword",user1.getPassword());
		assertNotEquals("",user1.getPassword());
	}

	@Test
	public final void testGetFname() {
		assertEquals("Nitin",user.getFname());
		assertNotEquals("NitinS29",user.getFname());
	}

	@Test
	public final void testSetFname() {
		user1.setFname("John");
		assertEquals("John",user1.getFname());
		assertNotEquals("",user1.getFname());
	}

	@Test
	public final void testGetMname() {
		assertEquals("",user.getMname());
		assertNotEquals("N",user.getMname());
	}

	@Test
	public final void testSetMname() {
		user1.setMname("Loyd");
		assertEquals("Loyd",user1.getMname());
		assertNotEquals("N",user1.getMname());
	}

	@Test
	public final void testGetLname() {
		assertEquals("Salvankar",user.getLname());
		assertNotEquals("",user.getLname());
	}

	@Test
	public final void testSetLname() {
		user1.setLname("Smith");
		assertEquals("Smith",user1.getLname());
		assertNotEquals("",user1.getLname());
	}

	@Test
	public final void testGetEmail() {
		assertEquals("email.test@gmail.com",user.getEmail());
		assertNotEquals("emailtest@gmail.com",user.getEmail());
	}

	@Test
	public final void testSetEmail() {
		user1.setEmail("myemail@gmail.com");
		assertEquals("myemail@gmail.com",user1.getEmail());
		assertNotEquals("emailtest@gmail.com",user1.getEmail());		
	}

	@Test
	public final void testGetPhone() {
		assertEquals(980785437,user.getPhone());
		assertNotEquals(0,user.getPhone());
	}

	@Test
	public final void testSetPhone() {
		user1.setPhone(980785437);
		assertEquals(980785437,user1.getPhone());
		assertNotEquals(0,user1.getPhone());
	}

	@Test
	public final void testGetAddress() {
		assertEquals("Charlotte",user.getAddress());
		assertNotEquals("NY",user.getAddress());
	}

	@Test
	public final void testSetAddress() {
		user1.setAddress("Atl");
		assertEquals("Atl",user1.getAddress());
		assertNotEquals("NY",user1.getAddress());
	}

	@Test
	public final void testGetUserType() {
		assertEquals(null,user.getUserType());
		assertNotEquals("admin",user.getUserType());
	}

	@Test
	public final void testSetUserType() {
		user1.setUserType("admin");
		assertNotEquals("",user1.getUserType());
		assertEquals("admin",user1.getUserType());
	}

}
