package com.concentrationApp.items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemsService {
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/concentration?useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "password";
	
	private static ArrayList<Item> items;
	
	public ArrayList<Item> retrieveItemsFor(int category, int userId) 
			throws ClassNotFoundException, SQLException {
		
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM all_items;");
		items = new ArrayList<Item>();
		
		while(rs.next()) {
			String item_name = rs.getString("item_name");
			String item_description = rs.getString("item_description");
			int item_category = rs.getInt("item_category");
			int user_id = rs.getInt("user_id");
			
			if(user_id == userId &&  item_category == category) {
				Item item = new Item(item_name, item_description, item_category, userId);
				items.add(item);
			}
		}
		rs.close();
		stmt.close();
		conn.close();
		return items;
	}
	
	// call after initializing items list from calling retrieveItemsFor()
	public void addItem(Item item) 
			throws ClassNotFoundException, SQLException {
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		Statement stmt = conn.createStatement();
		String insertText = "INSERT INTO all_items(item_name, item_description, item_category, user_id) VALUES ";
		stmt.executeUpdate(insertText + item +";");
		
		stmt.close();
		conn.close();
	}
	
	public void deleteItem(Item item) 
			throws ClassNotFoundException, SQLException {
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		Statement stmt = conn.createStatement();
		String insertText = "DELETE FROM all_items WHERE " +
				"item_name = \"" + item.getItemName() + "\" " + 
				"and item_description = \"" + item.getDescription() + "\" " + 
				"and item_category = \"" + item.getItemCategory() + "\" " + 
				"and user_id = \"" + item.getUserId() + "\" LIMIT 1;";
		System.out.println(insertText);
		stmt.executeUpdate(insertText);
		stmt.close();
		conn.close();
	}
	
	public void deleteItem(String item_name, String item_description, int item_category, int user_id) 
			throws ClassNotFoundException, SQLException {
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		Statement stmt = conn.createStatement();
		String insertText = "DELETE FROM all_items WHERE " +
				"item_name = \"" + item_name + "\" " + 
				"and item_description = \"" + item_description + "\" " + 
				"and item_category = \"" + item_category + "\" " + 
				"and user_id = \"" + user_id + "\" LIMIT 1;";
		System.out.println(insertText);
		stmt.executeUpdate(insertText);
		stmt.close();
		conn.close();
	}
	
	public Item parseItem(String itemString) {
		String[] itemFields = (itemString.substring(1, itemString.length() - 1)).split(",");
		String item_name = itemFields[0].trim();
		String item_description = itemFields[1].trim();
		int item_category = Integer.parseInt(itemFields[2].trim());
		int user_id = Integer.parseInt(itemFields[3].trim());
		
		return new Item(item_name, item_description, item_category, user_id);
	}
	
}











