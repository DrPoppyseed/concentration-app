package com.concentrationApp.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UserValidationService userValidation = new UserValidationService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
	}
	
	@Override 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int isValidUser = -1;
		
		try {
			isValidUser = userValidation.isUserValidId(username, password);
		} catch (ClassNotFoundException | SQLException e)	{
			System.out.println(e);
		}
		
		if (isValidUser != -1) {
			request.getSession().setAttribute("userId", isValidUser);
			response.sendRedirect("/home.do");
		} else {
			request.setAttribute("errorMessage", "Wrong username or password. Please try again.");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}
	
}
