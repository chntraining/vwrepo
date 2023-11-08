package com.vw.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @author Admin
 *
 */
public class MyDbConnection {

	static Connection con;
	
	
	/**
	 * <p>To get a connection from the db. . .
	 * <a href="http://www.supermanisthegreatest.com">Superman!</a>
	 * </p>
	 * @param no paramas
	 * @return Connection
	 * 
	 * @since 1.0
	 */
	public static Connection getMyDbConnection() {
		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vwdb ", "root", "root");
			System.out.println(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	
	public static void main(String[] args) {
		System.out.println(getMyDbConnection());

	}

}
