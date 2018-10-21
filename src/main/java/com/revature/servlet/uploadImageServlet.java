package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.revature.model.Reimbursement;
import com.revature.util.HibernateUtil;


@WebServlet("/image")
public class uploadImageServlet extends HttpServlet {
	Reimbursement item = (Reimbursement) getServletContext().getAttribute("item");
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part image = req.getPart("image");
//		byte i = IOUtils.toByteArray(image);
//		item.setReceipt(image);
	}
	
	@Override
	public void destroy() {
		HibernateUtil.shutdown();
	}
}
