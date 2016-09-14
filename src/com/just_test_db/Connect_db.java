package com.just_test_db;

import java.sql.Connection;
import java.sql.DriverManager;

class Connect_db {

	static Connection con = null;
	static String dbhost = "jdbc:mysql://localhost:3306/Test";
	static String dbuser = "root";
	static String dbpass = "";


	public static Connection getConnection() {
		if (con != null) return con;
		return getConnection(dbhost,dbuser,dbpass);
	}

	public static Connection getConnection(String dbhost, String dbuser, String dbpass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbhost,dbuser,dbpass);
			return con;
		}
		catch (Exception c) {
			System.out.println("Could not connect to the Database");
			c.printStackTrace();
		}

		return con;
	}
}