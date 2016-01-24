package com.hackbulgaria.corejava2;

import java.util.List;
import java.util.Map;

import com.hackbulgaria.corejava2.data.Gender;
import com.hackbulgaria.corejava2.data.Student;

public interface StudentOperations {

    public double getAverageMark();
    
    public List<Student> getAllPassing();
    
    public List<Student> getAllFailing();

    /**
     * Split the list of students into two groups - a group with equal or higher marks than the given `splitMark` ('true')
     * and the one with lower marks than the given `splitMark` ('false')
     * @return
     */
    public  Map<Boolean, List<Student>>  splitStudentsByMarks(float splitMark);
    
    public List<Student> orderByMarkDescending();
    
    public List<Student> orderByMarkAscending();
    /**
     * @return clusterize the students by their marks and return all the
     *         students with the highest mark. 
     *         
     *         Example: If Georgi and Ivo have
     *         6.0, but Radoslav has 5.0, you have to return Georgi and Ivo, but
     *         not Radoslav
     */
    public List<Student> getStudentsWithLowestMarks();
    
    public List<Student> getStudentsWithHighestMarks();
 
    /**
     * @return a map consisting of a List of marks per a given age, e.g.
     *         result.get(20) would return the list of all the marks of the
     *         students that are 20 years old.
     */
    public Map<Integer, List<Double>>  getMarksDistributionByAge();
    
    public Map<Gender, Double> getAverageMarkByGender();
    
    /**
     * example: Return a map that contains
     * 4.5 -> 3 times
     * 4.0 -> 2 times.
     * 2.0 -> 8 times.
     * @return
     */
    public Map<Double, Integer> getMarksDistribution();
    
    /**
     * @return "first@email.com, second@email.com, third@email.com..."
     */
    public String getEmailToHeader();
    
    
    /**
     * Split the students by their gender, and then partition them by their age
     */
    public Map<Gender, Map<Integer, List<Student>>> splitStudentMarksByGenderAndThenByAge();
}
