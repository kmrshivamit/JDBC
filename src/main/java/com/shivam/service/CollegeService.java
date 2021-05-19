package com.shivam.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.shivam.dao.CollegeDaoImpl;
import com.shivam.model.College;
import com.shivam.util.JDBCConnectionUtil;

import Exceptions.CollegeDaoException;
import Exceptions.JDBCUtilException;

public class CollegeService {
	static public College createCollege() throws SQLException, JDBCUtilException, CollegeDaoException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the name of college");
		String name = scanner.nextLine();
		System.out.println("Enter the strength of college");
		int strength = scanner.nextInt();
		College college = new College(name, strength);
		new CollegeDaoImpl().add(college);
		return college;
	}

	public static boolean isCollegeAvailable(String collegeName) throws SQLException, JDBCUtilException, CollegeDaoException {

		return new CollegeDaoImpl().isAvailable(collegeName);
	}

	static public int getStudentCount(String collegeName) throws SQLException, JDBCUtilException, CollegeDaoException {
		return new CollegeDaoImpl().getStudentCount(collegeName);
	}

	static public int getStudentCapacity(String collegeName) throws SQLException, JDBCUtilException, CollegeDaoException {
		return new CollegeDaoImpl().getCollegeCapacity(collegeName);
	}

}
