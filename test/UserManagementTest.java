package test;

import static org.junit.Assert.*;

import org.junit.Test;

import cmsys.Common.CmsysException;
import cmsys.UserManagement.Login;
import cmsys.UserManagement.Role;
import cmsys.UserManagement.User;

public class UserManagementTest {

	@Test
	public void testGetUserByUid() throws CmsysException {
		User user = User.getUserByUid(10000);
		assertEquals(user, null);
		
		user = User.getUserByUid(5);
		assertNotEquals(user, null);
	}
	
	@Test
	public void testLogin() throws CmsysException {
		User user = Login.login("a", "b");
		assertEquals(user, null);
		
		user = Login.login("admin", "admin");
		assertNotEquals(user, null);
	}
	
	public void testRole() throws CmsysException {
		assertEquals(Role.toString(0), "Administrator");
	}
	
	public void testUser() {
		User user = new User(100, "test", "fn", "ln", "email", 0, "rr");
		assertEquals(user.getEmail(), "email");
		assertEquals(user.getLastName(), "ln");
		assertEquals(user.getUID(), 100);
		assertEquals(user.getRA(), "rr");
		assertEquals(user.getRole(), 0);
		assertEquals(user.getFirstName(), "fn");
		assertEquals(user.getUsername(), "test");
	}

}
