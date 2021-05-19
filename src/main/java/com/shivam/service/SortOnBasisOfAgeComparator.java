package com.shivam.service;

import java.util.Comparator;

import com.shivam.model.Student;

public class SortOnBasisOfAgeComparator implements Comparator<Student> {

	public int compare(Student o1, Student o2) {
		if (o1.getAge() < o2.getAge())
			return -1;
		if (o1.getAge() > o2.getAge())
			return 1;
		return o1.getName().compareTo(o2.getName());
	}

}
