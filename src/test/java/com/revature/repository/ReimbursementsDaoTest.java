package com.revature.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimbursement;

import org.junit.jupiter.api.Test;

class ReimbursementsDaoTest {

	@Test
	void testGetReimbursements() {
		ReimbursementsDao dao = new ReimbursementsDao();
		List<Reimbursement> items = new ArrayList<>();
		items = dao.getReimbursements(6, 0, 0);
		
		assertNotNull(items);
	}
	
	@Test
	void testGetInfoReimbursement() {
		ReimbursementsDao dao = new ReimbursementsDao();
		Reimbursement item = dao.getReimbursement(27);
		
		assertEquals(100, item.getAmmount());
		assertEquals("Test", item.getDescription());
		assertNull(item.getReceipt());
		assertNotNull(item.getSubmitted());
		assertNull(item.getResolved());
		assertEquals(6, item.getAuthor());
		assertEquals(-1, item.getResolver());
		assertEquals(0, item.getType());
		assertEquals(0, item.getStatus());
	}
	
//	@Test
//	void testSaveRequest() {
//		UserDao dao = new UserDao();
//		User user = new User();
//		user = dao.getUser("test", "test");
//		
//		assertEquals(3, user.getId());
//		assertEquals("test", user.getuName());
//		assertEquals("test1", user.getPassword());
//		assertEquals("TestName", user.getfName());
//		assertEquals("NameName", user.getlName());
//		assertEquals("test@gmail.com", user.getEmail());
//		assertEquals(0, user.getUrId());
//	}
	
//	@Test
//	void testUpdateRequest() {
//		UserDao dao = new UserDao();
//		User user = new User();
//		user = dao.getUser("test", "test");
//		
//		assertEquals(3, user.getId());
//		assertEquals("test", user.getuName());
//		assertEquals("test1", user.getPassword());
//		assertEquals("TestName", user.getfName());
//		assertEquals("NameName", user.getlName());
//		assertEquals("test@gmail.com", user.getEmail());
//		assertEquals(0, user.getUrId());
//	}
}
