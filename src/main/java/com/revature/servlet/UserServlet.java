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
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//users = dao.getUsers();
//		resp.setContentType("text/xml");
//		ObjectMapper om = new XmlMapper();
//		//String obj = om.writeValueAsString(users);
//		String obj = om.writeValueAsString(dao.getUserByName("employee"));
//		PrintWriter pw = resp.getWriter();
//		pw.print(obj);
//		pw.close();
//	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao instance = new UserDao();
		String name = "", password = "";
		name = req.getParameter("uName");
		password = req.getParameter("password");
		User user = instance.getUser(name, password);

		PrintWriter pw = resp.getWriter();
		String action = req.getParameter("ACTION");
	    if("test".equals(action)){
            pw.print(user);
        }
	    else if(user == null) {
			RequestDispatcher rs = req.getRequestDispatcher("index.html"); 
	        rs.forward(req, resp);
		}
		else {
			getServletContext().setAttribute("user", user);
			RequestDispatcher rs = req.getRequestDispatcher("employee.html"); 
	        rs.forward(req, resp);
	        //resp.sendRedirect(req.getContextPath() + "/employee");

	    }
		

//		ObjectMapper om = new XmlMapper();
//		User postUser = (User) om.readValue(req.getInputStream(), User.class);
//		PrintWriter pw = resp.getWriter();
//		pw.print(dao.saveUser(postUser));
//		pw.close();
	}	
	
	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}
