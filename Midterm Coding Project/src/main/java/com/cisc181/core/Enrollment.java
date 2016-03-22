package com.cisc181.core;

import java.util.UUID;

public class Enrollment {

	private UUID SectionID;
	private UUID StudentID;
	private UUID EnrollmentID;
	private double Grade;
	private Section Section;

	private Enrollment(){this.EnrollmentID = UUID.randomUUID();}
	
	public double getGrade() {
		return Grade;
	}

	public void setGrade(double grade) {
		Grade = grade;
	}

	public UUID getSectionID() {
		return SectionID;
	}

	public UUID getStudentID() {
		return StudentID;
	}

	public UUID getEnrollmentID() {
		return EnrollmentID;
	}

	public Enrollment(Student stu, Section sec){
		this();
		this.SectionID = sec.getSectionID();
		this.Section = sec;
		this.StudentID = StudentID;
	}
	
	public Section getSection(){
		return this.Section;
	}

	public void SetGrade(double grade){this.Grade = grade;}
	
	public double getGPAFactor(){
		return this.Grade*this.Section.getGradePoints();
	}
}
