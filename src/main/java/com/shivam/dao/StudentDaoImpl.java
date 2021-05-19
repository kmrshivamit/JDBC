package com.shivam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.shivam.model.Student;
import com.shivam.util.CloseConnectionUtil;
import com.shivam.util.JDBCConnectionUtil;

import Exceptions.JDBCUtilException;
import Exceptions.StudentDaoException;

public class StudentDaoImpl implements StudentDao {

	public void add(Student student) throws JDBCUtilException, StudentDaoException {
		Connection connection = new JDBCConnectionUtil().getConnection();
		PreparedStatement preparedStatement = null;
		String sql = "insert into student(name,age,subject) " + "values(?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setByte(2, student.getAge());
			preparedStatement.setString(3, student.getSubject());
			int rt = preparedStatement.executeUpdate();
			System.out.println("Student added");
		} catch (SQLException e) {
			throw new StudentDaoException("Not able to add student ", e);
		} finally {
			CloseConnectionUtil.close(preparedStatement);

			CloseConnectionUtil.close(connection);
		}
	}

	public void assignCollege(Student student) throws JDBCUtilException, StudentDaoException {
		Connection connection = new JDBCConnectionUtil().getConnection();
		PreparedStatement preparedStatement=null;
		String sql = "update student set college_name=? where name=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, student.getCollegeName());
			preparedStatement.setString(2, student.getName());
			int rt = preparedStatement.executeUpdate();
			System.out.println("College Assigned");
		} catch (SQLException e) {
			throw new StudentDaoException("Not able to assign college", e);

		} finally {
			CloseConnectionUtil.close(preparedStatement);

			CloseConnectionUtil.close(connection);
		}

	}

	public List<Student> studentsWithGivenCollegeAndSubject(String subject, String collegeName)
			throws SQLException, JDBCUtilException, StudentDaoException {
		List<Student> list = new ArrayList<Student>();
		Connection connection = new JDBCConnectionUtil().getConnection();
		ResultSet resultSet=null;
		String sql = " select * from student where subject=? and college_name=?";
		PreparedStatement preparedStatement=null;
		try {
	    preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, subject);
		preparedStatement.setString(2, collegeName);
		 resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			list.add(new Student(resultSet.getString(1), resultSet.getByte(2), resultSet.getString(3),
					resultSet.getString(4)));
		}}
		catch(SQLException e)
		{
			throw new StudentDaoException("Not agle to get student"+
					"with given college and subject",e);
		}
	
		finally {
			CloseConnectionUtil.close(preparedStatement);
			CloseConnectionUtil.close(connection);
			CloseConnectionUtil.close(resultSet);
		}
return list;
	}
}
