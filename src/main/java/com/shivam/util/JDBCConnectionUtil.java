package com.shivam.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Exceptions.JDBCUtilException;

public class JDBCConnectionUtil {

	private static final String URL = "jdbc:mysql://localhost:3306/college_review";
	private static final String USER_NAME = "root";
	private static final String PASSWORD = "Shivam@11";

	public Connection getConnection() throws JDBCUtilException {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JDBCUtilException("Connection not able to create",e);
		}
		return con;

	}

}
