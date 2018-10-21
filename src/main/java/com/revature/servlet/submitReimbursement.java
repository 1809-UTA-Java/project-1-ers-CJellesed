package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.*;
import com.revature.repository.*;
import com.revature.util.HibernateUtil;

@WebServlet("/submit")
public class submitReimbursement extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ReimbursementsDao reim = new ReimbursementsDao();
		User user = (User) getServletContext().getAttribute("user");
		Reimbursement item = new Reimbursement();
		String ammount = "", description = "";
		
		ammount = req.getParameter("ammount");
		description = req.getParameter("description");
		String temp = req.getParameter("type");
		int type = Integer.valueOf(temp);
		item.setAmmount(Double.parseDouble(ammount));
		item.setAuthor(user.getId());
		item.setDescription(description);
		item.setType(type);

		PrintWriter pw = resp.getWriter();
		//pw.print(item);
		reim.saveRequest(item);
		getServletContext().setAttribute("item", item);
		
		RequestDispatcher rs = req.getRequestDispatcher("employee.html"); 
        rs.forward(req, resp);
	}
	
	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}
