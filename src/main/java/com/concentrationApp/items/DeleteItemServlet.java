package com.concentrationApp.items;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/delete-item.do")
public class DeleteItemServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ItemsService itemsService = new ItemsService();
	
	@Override 
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		String itemString = (String)request.getParameter("item");
		String[] itemFields = (itemString.substring(1, itemString.length() - 1)).split(",");
		String item_name = itemFields[0].trim();
		String item_description = itemFields[1].trim();
		int item_category = Integer.parseInt(itemFields[2].trim());
		int user_id = Integer.parseInt(itemFields[3].trim());
		
		String itemName = request.getParameter("item");
		System.out.println(itemName);
		
		try {
			itemsService.deleteItem(item_name, item_description, item_category, user_id);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		response.sendRedirect("/home.do");
	}
}