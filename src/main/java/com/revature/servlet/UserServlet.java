package com.revature.servlet;

import java.io.IOException;
import com.revature.repository.*;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.revature.model.User;
import com.revature.repository.UserDao;
import com.revature.util.HibernateUtil;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	List<User> users;
	UserDao dao = new UserDao();
		
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao dao = new UserDao();
		String name = "", password = "";
		name = req.getParameter("uName");
		password = req.getParameter("password");
		User user = dao.getUser(name, password);

	    if(user == null) {
			RequestDispatcher rs = req.getRequestDispatcher("index.html"); 
	        rs.forward(req, resp);
		}
		else {
			getServletContext().setAttribute("user", user);
			if(user.getUrId() == 1) {
				RequestDispatcher rs = req.getRequestDispatcher("manager.html"); 
		        rs.forward(req, resp);
			}
			else {
				RequestDispatcher rs = req.getRequestDispatcher("employee.html"); 
		        rs.forward(req, resp);
			}	
	    }
	}	
	
	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}
