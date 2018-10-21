package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class ReimbursementsDao {
	public List<Reimbursement> getReimbursements(int id, int status) {
		Reimbursement found = null;
		List<Reimbursement> items = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		
		items = session.createQuery(
				"from Reimbursement where author = :idVar and status = :idStatus")
				.setInteger("idVar", id)
				.setInteger("idStatus", status)
				.list();
		if (!items.isEmpty()) {
			found = items.get(0);
		}
		return items;
	}
	
	
	public void saveRequest(Reimbursement item) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(item);
		session.getTransaction().commit();
	}

}
