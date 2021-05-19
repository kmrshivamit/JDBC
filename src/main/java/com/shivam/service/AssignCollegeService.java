package com.shivam.service;

import java.sql.SQLException;
import java.util.Scanner;

import com.shivam.dao.CollegeDaoImpl;
import com.shivam.dao.StudentDaoImpl;
import com.shivam.model.Student;

import Exceptions.CollegeServiceException;

public class AssignCollegeService {
	public static  void assignCollege(Student student, String collegeName) throws Exception {
		// if number of student exceeds throw exception
		// if college is not available throw exception
		if (CollegeService.isCollegeAvailable(collegeName) == false)
			throw new CollegeServiceException("College name is not available");
		if (CollegeService.getStudentCount(collegeName) == CollegeService.getStudentCapacity(collegeName))
			throw new CollegeServiceException("College is full. Admession unsuccessful");
		student.setCollegeName(collegeName);
		new StudentDaoImpl().add(student);
		new StudentDaoImpl().assignCollege(student);
		new CollegeDaoImpl().updateStudentCount(collegeName);
	}
}
