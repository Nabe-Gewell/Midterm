package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {
	
	public static ArrayList<Staff> StaffList = new ArrayList<Staff>();
	@BeforeClass
	public static void setup() {
		Calendar AdateBorn = new GregorianCalendar(1965,2,21);
		Calendar AdateHire = new GregorianCalendar(2011,5,29);
		Staff A = new Staff("Fred","Ward","Flinstone", AdateBorn, "Yo Mamma's House",
				"(111)-111-1111","Fred@gmail.com","Never",3,1000000,AdateHire,eTitle.DR);
		Calendar BdateBorn = new GregorianCalendar(2000,5,4);
		Calendar BdateHire = new GregorianCalendar(2012,8,9);
		Staff B = new Staff("God","The","Almighty", BdateBorn, "Heaven",
				"0123456789","N/A","Always",1,0,BdateHire,eTitle.MR);
		Calendar CDateBorn = new GregorianCalendar(2001,5,4);
		Calendar CDateHire = new GregorianCalendar(2012,1,1);
		Staff C = new Staff("Satan","Lucifer","Devil",CDateBorn,"Hell",
				"0000000000","N/A","Always",2,0,CDateHire,eTitle.PHD);
		Calendar DDateBorn = new GregorianCalendar(1999,6,7);
		Calendar DDateHire = new GregorianCalendar(2011,5,8);
		Staff D = new Staff("Flying","Spaghetti","Monster",DDateBorn,"Earth",
				"(302)-659-8490","DrMonster@udel.edu","24/7",0,200000,DDateHire,eTitle.DR);
		Calendar EDateBorn = new GregorianCalendar(1996,8,10);
		Calendar EDateHire = new GregorianCalendar(2012,9,24);
		Staff E = new Staff("The","Great","Cornholio",EDateBorn,"Somewhere",
				"(298)-459-0500","Cornholia@yahoo.net","Sunday",53,200,EDateHire,eTitle.PROF);
		StaffList.add(A);
		StaffList.add(B);
		StaffList.add(C);
		StaffList.add(D);
		StaffList.add(E);
		
	}
	
	@Test
	public void SalaryTest() {
		double totalSalary = 0;
		for (Staff p:this.StaffList){
			totalSalary += p.getSalary();
		}
		double AverageCalculated = totalSalary/5;
		double AverageExpected = (1000000+0+0+200000+200)/5;
		assertTrue(AverageCalculated == AverageExpected);
		//assertEquals Deprecated
	}
	
	@Test
	public void DOBPhoneTest() {
		Calendar BadDob = new GregorianCalendar(1000,3,21);
		Calendar DateHire = new GregorianCalendar(2005,6,16);
		Staff BadDate = new Staff("Ed","Edd","Eddy",BadDob,"Nowhere",
				"(000)-000-0000","email","IDK",1,1,DateHire,eTitle.MS);
		assertFalse(BadDate.getValid());
		
		Staff BadPhone = new Staff("Ed","Edd","Eddy",DateHire,"Nowhere",
				"4","email","IDK",1,1,DateHire,eTitle.MS);
		assertFalse(BadPhone.getValid());
		
		Staff Good = new Staff("Ed","Edd","Eddy",DateHire,"Nowhere",
				"(444)-444-4444","email","IDK",1,1,DateHire,eTitle.MS);
		assertTrue(Good.getValid());
	}

}
