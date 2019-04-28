package com.concentrationApp.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserValidationService {
	
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/concentration";
	
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "password";
	
	public int isUserValidId(String user, String password) 
			throws ClassNotFoundException, SQLException {
		
		Class.forName(JDBC_DRIVER);
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT id, name, password FROM users;");
		
		while(rs.next()) {
			String dbNames = rs.getString("name");
			String dbPasswords = rs.getString("password");
			
			if (dbNames.equals(user) && dbPasswords.equals(password))
				return rs.getInt("id");
		}
		
		rs.close();
		stmt.close();
		conn.close();
		return -1;
	}
}
