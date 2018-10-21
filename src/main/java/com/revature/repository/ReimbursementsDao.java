package com.revature.repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.util.HibernateUtil;

public class ReimbursementsDao {
	public Reimbursement getReim(int id) {
		Reimbursement found = null;
		List<Reimbursement> items = new ArrayList<>();
		Session session = HibernateUtil.getSession();
		
		items = session.createQuery(
				"from Reimbursement where author = :idVar")
				.setInteger("idVar", id)
				.list();
		if (!items.isEmpty()) {
			found = items.get(0);
		}
		return found;
	}
	
	
	public void saveRequest(Reimbursement item) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		session.save(item);

		session.getTransaction().commit();
		session.close();
	}

}
