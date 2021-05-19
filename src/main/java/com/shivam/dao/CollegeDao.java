package com.shivam.dao;

import java.sql.SQLException;

import com.shivam.model.College;

import Exceptions.CollegeDaoException;
import Exceptions.JDBCUtilException;

public interface CollegeDao {

	void add(College college) throws SQLException, JDBCUtilException, CollegeDaoException;

	boolean isAvailable(String collegeName) throws SQLException, JDBCUtilException, CollegeDaoException;

	void updateStudentCount(String collegeName) throws SQLException, JDBCUtilException, CollegeDaoException;

}