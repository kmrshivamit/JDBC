package com.shivam.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exceptions.JDBCUtilException;

public class CloseConnectionUtil {

	public static void close(PreparedStatement preparedStatement) throws JDBCUtilException {
		try {
			preparedStatement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JDBCUtilException("not able to close preparedstatement", e);

		}
	}

	public static void close(Connection conection) throws JDBCUtilException {
		try {
			conection.close();
		} catch (SQLException e) {
			throw new JDBCUtilException("not able to close connection object ");
		}
	}

	public static void close(ResultSet resultSet) throws JDBCUtilException {
		try {
			resultSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new JDBCUtilException("not able to close resultSet object", e);

		}
	}

}
