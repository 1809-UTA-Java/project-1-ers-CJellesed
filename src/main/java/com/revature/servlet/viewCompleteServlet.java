package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Reimbursement;
import com.revature.util.HibernateUtil;

@WebServlet("/complete")
public class viewCompleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Reimbursement item = new Reimbursement();
		//item = dao.getComplete();
		PrintWriter pw = resp.getWriter();
		pw.print(item);
	}
	
	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}
