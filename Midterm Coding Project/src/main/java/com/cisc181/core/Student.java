package com.cisc181.core;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Student extends Person {

	private eMajor Major;
	private UUID StudentID;
	private ArrayList<Enrollment> EnrollmentList = new ArrayList<Enrollment>();
	
	public eMajor getMajor ( )
    {
        return this.Major;
    }
    public void setMajor (eMajor Major)
    {
        this.Major = Major;    
    }
    
    public UUID getStudentID(){
    	return this.StudentID;
    }
    
	public Student(String FirstName, String MiddleName, String LastName,Calendar DOB, eMajor Major,
			String Address, String Phone_number, String Email)
	{
		super(FirstName, MiddleName, LastName, DOB, Address, Phone_number, Email);
		this.StudentID = UUID.randomUUID();
		this.Major = Major;
		
	}
		@Override
	public void PrintName() {
		System.out.println(getLastName() + ","  + getFirstName() + ' ' + getMiddleName());
	}
	public void PrintName(boolean bnormal)
	{
		super.PrintName();
	}
	public ArrayList<Enrollment> getEnrollmentList() {
		return EnrollmentList;
	}
	public void addEnrollement(Section s,double Grade){
		Enrollment E = new Enrollment(this,s);
		E.setGrade(Grade);
		this.EnrollmentList.add(E);
	}
	public double CalculateGPA(){
		double total = 0;
		int num = 0;
		for (Enrollment e:this.EnrollmentList){
			total += e.getGPAFactor();
			num += e.getGPAFactor()/e.getGrade();//Grade Points
		}
		return total/num; 
	}

}