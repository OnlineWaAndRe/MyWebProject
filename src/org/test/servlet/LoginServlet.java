package org.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.test.entity.User;
import org.test.service.UserService;
//�������㣺����view������󲢷ַ���MODEL����
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uname = request.getParameter("uname");
		String upsd = request.getParameter("upsd");
		User user = new User(uname, upsd);
		UserService us = new UserService();
		PrintWriter out = response.getWriter();
		boolean isExists = us.isExists(user);
		if(isExists) {
			us.close();
			out.print("hello");//�Ժ����������ת�������˵�
		}else {
			us.close();
			response.sendRedirect("register.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
