package com.hackbulgaria.corejava2.data;

import java.util.Calendar;

public class Student {
    private final String name;
    private final int age;
    private final double grade;
    private final Gender gender;

    /**
     * @param name
     * @param age
     * @param grade - between 2 and 6
     */
    public Student(String name, int age, double grade, Gender gender){
	this.name = name;
	this.age = age;
	this.grade = grade;
	this.gender = gender;
    }

    public String getName() {
	return name;
    }

    public int getAge() {
	return age;
    }

    public double getGrade() {
	return grade;
    }

    public Gender getGender() {
	return gender;
    }
    
    public String getEmail(){
	return name + "_" + (Calendar.getInstance().get(Calendar.YEAR) - age) + "@gmail.com";
    }
}
