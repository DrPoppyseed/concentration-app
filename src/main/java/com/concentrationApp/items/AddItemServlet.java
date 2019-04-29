package com.concentrationApp.items;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/add-item.do")
public class AddItemServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ItemsService itemsService = new ItemsService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-item.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String item_name = request.getParameter("item_name");
		String item_description = request.getParameter("item_description");
		int item_category = Integer.parseInt(request.getParameter("item_category"));
		int user_id = (int) request.getSession(false).getAttribute("userId");
		Item newItem = new Item(item_name, item_description, item_category, user_id);
		
		try {
			System.out.println(newItem);
			itemsService.addItem(newItem);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		response.sendRedirect("/home.do");
	}
}