package com.concentrationApp.home;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.concentrationApp.items.Item;
import com.concentrationApp.items.ItemsService;


@WebServlet(urlPatterns="/home.do")
public class HomeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ItemsService itemsService = new ItemsService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		int user_id = (int)request.getSession(false).getAttribute("userId");
		try {
			ArrayList<Item> items_1 = itemsService.retrieveItemsFor(1, user_id);
			ArrayList<Item> items_2 = itemsService.retrieveItemsFor(2, user_id);
			request.setAttribute("items_1", items_1);
			request.setAttribute("items_2", items_2);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
		}
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}
	
}
