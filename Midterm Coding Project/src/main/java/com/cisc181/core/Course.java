package com.cisc181.core;

import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Course {
	
	protected UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor Major;

	public Course(){this.CourseID = UUID.randomUUID();}
	
	public Course(String Name){
		this();
		this.CourseName = Name;
	}

	public Course(String Name, int pts){
		this(Name);
		this.GradePoints = pts;
	}

	public Course(String Name, int pts, eMajor Major){
		this(Name,pts);
		this.Major = Major;
	}

	
	public UUID getCourseID(){return this.CourseID;}

	public String getCourseName(){return this.CourseName;}
	
	public int getGradePoints(){return this.GradePoints;}
	
	public eMajor getMajor(){return this.Major;}
	
	public void setCourseName(String name){
		this.CourseName = name;
	}
	
	public void setGradePoints(int pts){this.GradePoints = pts;}
	
	public void setMajor(eMajor major){this.Major = major;}
	
	public void setID(UUID ID){
		this.CourseID = ID;
	}
}
