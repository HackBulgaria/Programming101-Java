/**
 * 
 */
package com.hackbulgaria.corejava2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.model.InitializationError;
import org.reflections.Reflections;

import com.hackbulgaria.corejava2.data.Gender;
import com.hackbulgaria.corejava2.data.Student;
import com.hackbulgaria.corejava2.data.StudentsDataFactory;

/**
 * @author georgi
 *
 */
public class StudentOperationsImplTest {
    private StudentOperations studentOperations;
    private java.util.List<Student> allStudents;

    @Before
    public void setup() throws InitializationError, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
	Reflections reflections = new Reflections(getClass().getPackage().getName());
	Set<Class<? extends StudentOperations>> subtypes = reflections.getSubTypesOf(StudentOperations.class);
	if (subtypes.isEmpty()){
	    throw new InitializationError("You have not subclassed" + StudentOperations.class.getCanonicalName());
	}
	if (subtypes.size() > 1){
	    throw new InitializationError("One subclass of " + StudentOperations.class.getCanonicalName() + " will do, No need for more.");
	}
	this.allStudents = StudentsDataFactory.getAllStudents();
	this.studentOperations = subtypes.iterator().next().getConstructor(java.util.List.class).newInstance(allStudents);
    }
    
    @Test
    public void testGetStudentsWithLowestMarks() throws Exception {
	java.util.List<Student> students = studentOperations.getStudentsWithLowestMarks();
	assertTrue(students.size() == 3);
	assertTrue(students.stream().filter(s -> s.getGrade() != 2.0f).count() == 0);
    }
    
    @Test
    public void testGetStudentsWIthHighestMarks() throws Exception{
	List<Student> students = studentOperations.getStudentsWithHighestMarks();
	assertTrue(students.size() == 2);
	assertTrue(students.stream().filter(s -> s.getGrade() != 6.0f).count() == 0);
    }

    /**
     * Test method for {@link com.hackbulgaria.corejava2.StudentOperationsImpl#getAllPassing()}.
     */
    @Test
    public void testGetAllPassing() {
	List<Student> students = studentOperations.getAllPassing();
	assertTrue(students.stream().filter(s -> s.getGrade() < 3.0f).count() == 0);
    }

    /**
     * Test method for {@link com.hackbulgaria.corejava2.StudentOperationsImpl#getAllFailing()}.
     */
    @Test
    public void testGetAllFailing() {
	List<Student> students = studentOperations.getAllFailing();
	assertTrue(students.stream().filter(s -> s.getGrade() >= 3.0f).count() == 0);
    }

    /**
     * Test method for {@link com.hackbulgaria.corejava2.StudentOperationsImpl#getAverageMark()}.
     */
    @Test
    public void testGetAverageMark() {
	double avgMark = studentOperations.getAverageMark();
	assertTrue(String.valueOf(avgMark).startsWith("4.142"));
    }

    /**
     * Test method for {@link com.hackbulgaria.corejava2.StudentOperationsImpl#splitStudentsByMarks(float)}.
     */
    @Test
    public void testSplitStudentsByMarks() {
	Map<Boolean, List<Student>> map = studentOperations.splitStudentsByMarks(3.5f);
	System.out.println(map.get(Boolean.TRUE).size());
	assertTrue(map.get(Boolean.TRUE).size() == 15);
    }

    /**
     * Test method for {@link com.hackbulgaria.corejava2.StudentOperationsImpl#orderByMarkDescending()}.
     */
    @Test
    public void testOrderByMarkDescending() {
	List<Student> students = studentOperations.orderByMarkDescending();
	for (int i = 1; i < students.size(); i++){
	    Student prev = students.get(i-1);
	    assertTrue(prev.getGrade() >= students.get(i).getGrade());
	}
    }

    /**
     * Test method for {@link com.hackbulgaria.corejava2.StudentOperationsImpl#orderByMarkAscending()}.
     */
    @Test
    public void testOrderByMarkAscending() {
	List<Student> students = studentOperations.orderByMarkAscending();
	for (int i = 1; i < students.size(); i++){
	    Student prev = students.get(i-1);
	    assertTrue(prev.getGrade() <= students.get(i).getGrade());
	}
    }

    /**
     * Test method for {@link com.hackbulgaria.corejava2.StudentOperationsImpl#getMarksDistributionByAge()}.
     */
    @Test
    public void testDistributeByAge() {
	Map<Integer, List<Double>>  gradesByAge = studentOperations.getMarksDistributionByAge();
	assertTrue(gradesByAge.get(20).stream().reduce(Double::sum).get().compareTo(15.0) == 0);
    }

    /**
     * Test method for {@link com.hackbulgaria.corejava2.StudentOperationsImpl#getAverageMarkByGender()}.
     */
    @Test
    public void testGetAverageMarkByGender() {
	Map<Gender, Double> avg= studentOperations.getAverageMarkByGender();
	assertTrue(avg.keySet().size() == 2);
	double maleAvg = allStudents.stream().filter(s -> s.getGender().equals(Gender.MALE)).mapToDouble(Student::getGrade).average().getAsDouble();
	assertTrue(avg.get(Gender.MALE).compareTo(maleAvg) == 0);
    }

    /**
     * Test method for {@link com.hackbulgaria.corejava2.StudentOperationsImpl#getMarksDistribution()}.
     */
    @Test
    public void testDistributeMarks() {
	Map<Double, Integer> distribution = studentOperations.getMarksDistribution();
	assertTrue(distribution.get(2.0) == 3);
	assertTrue(distribution.get(6.0) == 2);
	assertTrue(distribution.get(4.5) == 2);
    }

    /**
     * Test method for {@link com.hackbulgaria.corejava2.StudentOperationsImpl#getEmailToHeader()}.
     */
    @Test
    public void testGetEmailToHeader() {
	String expectedResult = "Georgi_1996@gmail.com, Dimitur_1994@gmail.com, Vasil_1996@gmail.com, Tihomir_1995@gmail.com, Ivomir_1995@gmail.com, Vladislav_1994@gmail.com, Filip_1996@gmail.com, Boris_1995@gmail.com, Genady_1994@gmail.com, Ivan_1994@gmail.com, Elena_1994@gmail.com, Radoslav_1993@gmail.com, Maria_1993@gmail.com, Teodor_1993@gmail.com, Stanislava_1993@gmail.com, Anton_1995@gmail.com, Marina_1994@gmail.com, Salfetka_1994@gmail.com, Zlatina_1993@gmail.com, Petar_1996@gmail.com, Yanitsa_1994@gmail.com";
	assertEquals(expectedResult.replaceAll("\\s+", "").toLowerCase(), studentOperations.getEmailToHeader().replaceAll("\\s+", "").toLowerCase());
    }

    /**
     * Test method for {@link com.hackbulgaria.corejava2.StudentOperationsImpl#splitStudentMarksByGenderAndThenByAge()}.
     */
    @Test
    public void testSplitStudentMarksByGenderAndThenByAge() {
	Map<Gender, Map<Integer, List<Student>>> map = studentOperations.splitStudentMarksByGenderAndThenByAge();
	assertTrue(map.keySet().size() == 2);
	assertTrue(map.get(Gender.MALE).get(20).size() == 4);
	assertTrue(map.get(Gender.MALE).get(21).size() == 4);
    }

}
