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

import com.revature.model.User;
import com.revature.repository.UserDao;
import com.revature.util.HibernateUtil;

@WebServlet("/employee")
public class employeeServlet extends HttpServlet {
	List<User> users;
	UserDao dao = new UserDao();

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User)req.getAttribute("user");
//		UserDao instance = new UserDao();
//		String name = "", password = "";
//		name = req.getParameter("uName");
//		password = req.getParameter("password");
//
		PrintWriter pw = resp.getWriter();
		if(getServletContext().getAttribute("user") == null)
			pw.print("null");
		else
			pw.print(getServletContext().getAttribute("user"));
		//pw.print("Here we are");
//		if(user == null) {
//			RequestDispatcher rs = req.getRequestDispatcher("index.html"); 
//	        rs.forward(req, resp);		}
//		else {
//			RequestDispatcher rs = req.getRequestDispatcher("employee.html"); 
//	        rs.forward(req, resp);
//	    }

	}
	
	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}

