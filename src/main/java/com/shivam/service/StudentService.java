package com.shivam.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.shivam.dao.StudentDaoImpl;
import com.shivam.model.Student;

import Exceptions.JDBCUtilException;
import Exceptions.StudentDaoException;

public class StudentService {
	public static Student createStudent() throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name of the student");
		String name = scanner.nextLine();
		System.out.println("Enter subject");
		String subject = scanner.nextLine();
		System.out.println("Enter age of student");
		byte age = scanner.nextByte();
		Student student = new Student(name, age, subject);
		return student;
	}

	public static List<Student> studentsWithGivenCollegeAndSubject()
			throws SQLException, JDBCUtilException, StudentDaoException {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Subject");
		String subject = s.nextLine();
		System.out.println("Enter College Name");
		String collegeName = s.nextLine();
		return new StudentDaoImpl().studentsWithGivenCollegeAndSubject(subject, collegeName);
	}

	public static List<Student> sortOnTheBasisOfAge(List<Student> list) {
		List<Student> sortedList = new ArrayList<Student>();
		for (Student student : list)
			sortedList.add(student);
		Collections.sort(sortedList, new SortOnBasisOfAgeComparator());
		return sortedList;
	}

}