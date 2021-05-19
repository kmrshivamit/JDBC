package com.shivam.model;

public class Student {
	String name;
	byte age;
	String subject;
	String collegeName;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, byte age, String subject) {
		super();
		this.name = name;
		this.age = age;
		this.subject = subject;
	}

	public Student(String name, byte age, String subject, String collegeName) {
		super();
		this.name = name;
		this.age = age;
		this.subject = subject;
		this.collegeName = collegeName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", subject=" + subject + ", collegeName=" + collegeName + "]";
	}

}
