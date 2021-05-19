package com.shivam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.shivam.model.College;
import com.shivam.service.CollegeService;
import com.shivam.util.CloseConnectionUtil;
import com.shivam.util.JDBCConnectionUtil;

import Exceptions.CollegeDaoException;
import Exceptions.JDBCUtilException;

public class CollegeDaoImpl implements CollegeDao {

	public void add(College college) throws JDBCUtilException, CollegeDaoException {
		Connection connection = new JDBCConnectionUtil().getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "insert into college(name,strength,number_of_students) " + "values(?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, college.getName());
			preparedStatement.setInt(2, college.getStrength());
			preparedStatement.setInt(3, college.getNumberOfStudents());
			preparedStatement.executeUpdate();
			System.out.println("College added");
		} catch (SQLException e) {
			throw new CollegeDaoException("Not able to add college", e);

		} finally {
			CloseConnectionUtil.close(connection);
			CloseConnectionUtil.close(preparedStatement);
		}
	}

	public boolean isAvailable(String collegeName) throws JDBCUtilException, CollegeDaoException {
		Connection connection = new JDBCConnectionUtil().getConnection();
		ResultSet resultSet;
		Boolean isAvailable = false;
		String sql = "select * from college where name=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, collegeName);

			resultSet = preparedStatement.executeQuery();

			isAvailable = resultSet.next();
		} catch (SQLException e) {
			throw new CollegeDaoException("Not able to detect college availability", e);
		} finally {
			CloseConnectionUtil.close(connection);
			CloseConnectionUtil.close(preparedStatement);
		}
		return isAvailable;
	}

	public int getStudentCount(String collegeName) throws SQLException, JDBCUtilException, CollegeDaoException {
		Connection connection = new JDBCConnectionUtil().getConnection();
		PreparedStatement preparedStatement = null;
		int count = 0;
		String sql = "select number_of_students from college where name=? ";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, collegeName);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			count = resultSet.getInt(1);
		} catch (SQLException e) {
			throw new CollegeDaoException("not able to getstudent count", e);

		} finally {
			CloseConnectionUtil.close(connection);
			CloseConnectionUtil.close(preparedStatement);
		}

		return count;

	}

	public int getCollegeCapacity(String collegeName) throws SQLException, JDBCUtilException, CollegeDaoException {
		Connection connection = new JDBCConnectionUtil().getConnection();
		String sql = "select strength from college where name=? ";
		int strength = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, collegeName);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			strength = resultSet.getInt(1);
		} catch (SQLException e) {
			throw new CollegeDaoException("Not able to get colege capacity", e);

		} finally {
			CloseConnectionUtil.close(connection);
			CloseConnectionUtil.close(preparedStatement);
		}

		return strength;

	}

	public void updateStudentCount(String collegeName) throws SQLException, JDBCUtilException, CollegeDaoException {
		Connection connection = new JDBCConnectionUtil().getConnection();
		String sql = "update college set number_of_students=? where name=?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			int numberOfStudentsInCollege = CollegeService.getStudentCount(collegeName);
			preparedStatement.setInt(1, numberOfStudentsInCollege + 1);
			preparedStatement.setString(2, collegeName);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new CollegeDaoException("Not able to update student", e);
		}
		preparedStatement.close();
		connection.close();
	}

}
