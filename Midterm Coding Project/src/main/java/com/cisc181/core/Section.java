package com.cisc181.core;

import java.util.UUID;

public class Section extends Course{
	
	private UUID SemesterID;
	private UUID SectionID;
	private int RoomID;

	public Section(Course c){
		super(c.getCourseName(),c.getGradePoints(),c.getMajor());
		this.setID(c.getCourseID());
		this.SectionID = UUID.randomUUID();
	}

	public Section(Course c, Semester s){
		this(c);
		this.SemesterID = s.getSemesterID();
	}

	public Section(Course c, Semester s, int room){
		this(c,s);
		this.RoomID = room;
	}
	
	public UUID getSemesterID(){return this.SemesterID;}
	public UUID getSectionID(){return this.SectionID;}
	public int getRoomID(){return this.RoomID;}
	public void setRoomID(int num){this.RoomID = num;}
	}
