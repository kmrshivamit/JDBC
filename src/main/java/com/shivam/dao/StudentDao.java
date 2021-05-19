package com.shivam.dao;

import java.sql.SQLException;
import java.util.List;

import com.shivam.model.Student;

import Exceptions.JDBCUtilException;
import Exceptions.StudentDaoException;

public interface StudentDao {

	void add(Student student) throws JDBCUtilException, StudentDaoException, SQLException;

	void assignCollege(Student student) throws SQLException, JDBCUtilException, StudentDaoException;

	List<Student> studentsWithGivenCollegeAndSubject(String subject, String collegeName) throws SQLException, JDBCUtilException, StudentDaoException;

}