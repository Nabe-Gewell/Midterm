package com.cisc181.core;



import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;


public class Student_Test {

	public static ArrayList<Course> CourseList = new ArrayList<Course>();
	public static ArrayList<Semester> SemesterList = new ArrayList<Semester>();
	public static ArrayList<Section> SectionList = new ArrayList<Section>();
	public static ArrayList<Student> StudentList = new ArrayList<Student>();
	
	@BeforeClass
	public static void setup() {
		Course Physics = new Course("Quantum Mechanics",3,eMajor.PHYSICS);
		Course Econ = new Course("Accounting",3,eMajor.BUSINESS);
		Course Biology = new Course("Intro",4,eMajor.NURSING);
		CourseList.add(Physics);
		CourseList.add(Econ);
		CourseList.add(Biology);
		Semester Fall2015 = new Semester();
		Semester Spring2016 = new Semester();
		SemesterList.add(Fall2015);
		SemesterList.add(Spring2016);
		for (Semester s:SemesterList){
			for (Course c:CourseList){
				Section Sec = new Section(c,s);
				SectionList.add(Sec);
		}}
		Calendar DOB = new GregorianCalendar(1999,2,5);
		for (int i=0; i<10; i++){
			Student A = new Student("A","B","C",DOB,eMajor.PHYSICS,"Place","(111)-111-1111","Email");
			StudentList.add(A);
		}
		//Changing major
		Student a = StudentList.get(9);
		a.setMajor(eMajor.NURSING);
		StudentList.remove(9);
		StudentList.add(9, a);
	}
	

	@Test
	public void GPATest() {
		for (Student stu:StudentList){
			for (Section sec:SectionList){
				stu.addEnrollement(sec, 50);
		}}
		for (Student stu:StudentList){
			double GPA = stu.CalculateGPA();
			assertTrue(GPA == 50);
		}
	}
	
	@Test
	public void CourseAvgTest(){
		for (Course c:CourseList){
			double totalGrade = 0;
			int num = 0;
			for (Student stu:StudentList){
				for (Enrollment E:stu.getEnrollmentList()){
					if (E.getSection().getCourseID() == c.getCourseID()){
						totalGrade += E.getGrade();
						num += 1;
					}
			}}
			double AverageGrade = totalGrade/num;
			assertTrue(AverageGrade == 50);
		}
	}
}