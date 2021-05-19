package com.shivam.client;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.shivam.model.Student;
import com.shivam.service.AssignCollegeService;
import com.shivam.service.CollegeService;
import com.shivam.service.StudentService;
import com.shivam.util.StudentPrinter;

import Exceptions.CollegeDaoException;
import Exceptions.JDBCUtilException;
import Exceptions.StudentDaoException;

//Create students and assign to a college. While creating students if it exceeds total strength of that college then throw an user defined exception” Exceeding total strength”.

public class Main {
	public static void main(String args[]) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		boolean isContinue = false;
		do {
			switch (menu()) {
			case 1:
				// Create College
				try {
					CollegeService.createCollege();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JDBCUtilException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (CollegeDaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				// create student and assign to college
				Student student = StudentService.createStudent();
				System.out.println("Enter college name");
				String collegeName = scanner.nextLine();
				try {
					boolean isAvailable = CollegeService.isCollegeAvailable(collegeName);
					AssignCollegeService.assignCollege(student, collegeName);

				} catch (Exception exception) {
					System.out.println(exception.getMessage());
				}
				// test no of students in college
				// test college available

				// StudentService.assignStudentToCollege();
				break;
			case 3:
				// Take college name and subject and list all students
				List<Student> list = null;
				try {
					list = StudentService.studentsWithGivenCollegeAndSubject();
				} catch (JDBCUtilException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (StudentDaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (list.size() == 0) {
					System.out.println("Data not available for given input");
					break;
				}
				List<Student> sorted = StudentService.sortOnTheBasisOfAge(list);
				StudentPrinter.printList(sorted);
				break;

//			Show all the students data for a given college and particular subject as input . Display all students name based on their age in descending order.
			default:
				System.out.println("Enter correct choice");
			}
			System.out.println("Enter true to continue and false to not continue");
			isContinue = scanner.nextBoolean();
		} while (isContinue);
		System.out.println("Thanks for using our service");
	}

	static int menu() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 1 to add college");
		System.out.println("Enter 2 to assign student to college");
		System.out.println(
				"Enter 3 to show all the students data for a given college and particular subject as input . Display all students name based on their age in descending order.");

		return s.nextInt();
	}
}
