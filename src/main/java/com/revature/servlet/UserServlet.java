package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.revature.model.User;
import com.revature.repository.UserDao;
import com.revature.util.HibernateUtil;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	List<User> users;
	UserDao dao = new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//users = dao.getUsers();
		resp.setContentType("text/xml");
		ObjectMapper om = new XmlMapper();
		//String obj = om.writeValueAsString(users);
		String obj = om.writeValueAsString(dao.getUserByName("employee"));
		PrintWriter pw = resp.getWriter();
		pw.print(obj);
		pw.close();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper om = new XmlMapper();
		User postUser = (User) om.readValue(req.getInputStream(), User.class);
		PrintWriter pw = resp.getWriter();
		pw.print(dao.saveUser(postUser));
		pw.close();
	}	
	
	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}
