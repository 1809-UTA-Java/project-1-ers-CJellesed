package com.revature.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.revature.model.User;

import org.junit.jupiter.api.Test;

class ReimbursementsDaoTest {
	User user = new User();
	UserDao dao = new UserDao();
	
	user = dao.getUser("test", "test");
	@Test
	void testGetInfo() {
		assertEquals(3, user.getId());
		assertEquals("test", user.getuName());
		assertEquals("test1", user.getPassword());
		assertEquals("TestName", user.getfName());
		assertEquals("NameName", user.getlName());
		assertEquals("test@gmail.com", user.getEmail());
		assertEquals(0, user.getUrId());
	}

}
