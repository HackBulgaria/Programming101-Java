package com.hackbulgaria.corejava2.data;

import java.util.ArrayList;
import java.util.List;

public class StudentsDataFactory {
    public static List<Student> getAllStudents(){
	List<Student> students = new ArrayList<Student>();
	students.add(new Student("Georgi", 19, 2.0f, Gender.MALE));
	students.add(new Student("Dimitur", 21, 2.0f, Gender.MALE));
	students.add(new Student("Vasil", 19, 2.0f, Gender.MALE));

	students.add(new Student("Tihomir", 20, 3.0f, Gender.MALE));
	students.add(new Student("Ivomir", 20, 3.0f, Gender.MALE));
	students.add(new Student("Vladislav", 21, 3.0f, Gender.MALE));

	students.add(new Student("Filip", 19, 3.5f, Gender.MALE));
	students.add(new Student("Boris", 20, 3.5f, Gender.MALE));

	students.add(new Student("Genady", 21, 4.0f, Gender.MALE));
	students.add(new Student("Ivan", 21, 4.0f,Gender.MALE));
	students.add(new Student("Elena", 21, 4.0f, Gender.FEMALE));

	students.add(new Student("Radoslav", 22, 4.5f, Gender.MALE));
	students.add(new Student("Maria", 22, 4.5f,Gender.FEMALE));

	students.add(new Student("Teodor", 22, 5.0f,Gender.MALE));
	students.add(new Student("Stanislava", 22, 5.0f, Gender.FEMALE));

	students.add(new Student("Anton", 20, 5.5f, Gender.MALE));
	students.add(new Student("Marina", 21, 5.5f, Gender.FEMALE));
	students.add(new Student("Salfetka", 21, 5.5f, Gender.FEMALE));
	students.add(new Student("Zlatina", 22, 5.5f, Gender.FEMALE));

	students.add(new Student("Petar", 19, 6.0f, Gender.MALE));
	students.add(new Student("Yanitsa", 21, 6.0f, Gender.FEMALE));
	return students;
    }
}
