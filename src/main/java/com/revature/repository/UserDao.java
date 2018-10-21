package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class UserDao {
	
	public List<User> getUsers() {
		Session session = HibernateUtil.getSession();
		return session.createQuery("from User").list();
	}
	
	public User getUser(String uName, String password) {
		User found = null;
		List<User> users = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		
		users = session.createQuery(
				"from User where uName = :nameVar and password = :passVar")
				.setString("nameVar", uName)
				.setString("passVar", password)
				.list();
		if (!users.isEmpty()) {
			found = users.get(0);
		}
		return found;
	}
		
	public void updateUser(User a) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.update(a);
		session.getTransaction().commit();
	}

}
