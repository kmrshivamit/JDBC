package com.shivam.model;

public class College {

	private String name;
	private int strength;
	private int numberOfStudents;

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	public College(String name, int strength) {
		super();
		this.name = name;
		this.strength = strength;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

}
