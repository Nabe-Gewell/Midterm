package com.cisc181.core;

import java.util.Date;
import java.util.UUID;

public class Semester {
	
	private UUID SemesterID;
	private Date StartDate;
	private Date EndDate;
	
	public Semester(){this.SemesterID = UUID.randomUUID();}

	public Semester(Date Start,Date End){
		this();
		this.setStartDate(Start);
		this.setEndDate(End);
	}
	public UUID getSemesterID() {
		return SemesterID;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}	
}
