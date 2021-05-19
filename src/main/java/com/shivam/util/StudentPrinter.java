package com.shivam.util;

import java.util.List;

import com.shivam.model.Student;

public class StudentPrinter {

	public static void printList(List<Student> list) {
		for (Student student : list)
			System.out.println(student);
	}
}
