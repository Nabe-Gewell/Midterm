package com.cisc181.core;

import java.util.Calendar;

import com.cisc181.eNums.eTitle;

public class Staff extends Employee {

	 private eTitle Title;

	   public Staff(eTitle title){
	        this.Title = title;
	    }

	    public void setTitle(eTitle title){
	        this.Title = title;
	    }
	    public eTitle getTitle(){
	        return this.Title;
	    }

	    public Staff(String FirstName, String MiddleName, String LastName,
			Calendar DOB, String Address, String Phone_number, String Email,
			String officeHours, int rank, double salary, Calendar hiredate,
			eTitle Title) 
	
	{
		super(FirstName, MiddleName, LastName, DOB, Address, Phone_number,
				Email, officeHours, salary, hiredate);
		
		this.Title = Title;
	}

}