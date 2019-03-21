package org.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.test.entity.User;
import org.test.service.UserService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname");
		String upsd = request.getParameter("upsd");
		User user = new User(uname,upsd);
		UserService us = new UserService();
		if(us.isExists(user)) {
			response.getWriter().print("please think a anthor one name");
			response.sendRedirect("register.jsp");
		}else {
			us.addUser(user);
			response.sendRedirect("index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
