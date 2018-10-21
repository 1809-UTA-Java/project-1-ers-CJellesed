package com.revature.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.model.User;

class UserDaoTest {

	@Test
	void test() {
		UserDao dao = new UserDao();
		User user = dao.getUser("test", "test");
		
		assertEquals(6, user.getId());
		assertEquals("test", user.getuName());
		assertEquals("test", user.getPassword());
		assertEquals("test", user.getuName());
		assertEquals("TestName", user.getfName());
		assertEquals("NameName", user.getlName());
		assertEquals("test@gmail.com", user.getEmail());
		assertEquals(0, user.getUrId());
	}

}
