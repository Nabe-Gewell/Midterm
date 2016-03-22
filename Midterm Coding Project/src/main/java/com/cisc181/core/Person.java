package com.cisc181.core;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Exceptions.PersonException;

public abstract class Person implements java.io.Serializable {

	private Calendar DOB;
	private String FirstName;
	private String MiddleName;
	private String LastName;
	private String address;
	private String phone_number;
	private String email_address;
	private boolean isValid = true;

	public String getFirstName() {
		return FirstName;
	}
	
	public boolean getValid(){return this.isValid;}

	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String MiddleName) {
		this.MiddleName = MiddleName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String LastName) {
		this.LastName = LastName;
	}

	public Calendar getDOB() {
		return DOB;
	}
	public void setDOB(Calendar dOB2) throws PersonException{
		Calendar today = Calendar.getInstance();
		today.add(today.YEAR, -100);
		if (today.before(dOB2)){
			this.DOB = dOB2;
		}
		else{
			throw new PersonException(this);
		}
	}
	public void setAddress(String newAddress) {
		address = newAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setPhone(String newPhone_number) throws PersonException{
		String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(newPhone_number);
		if (matcher.matches()){
			this.phone_number = newPhone_number;
		}
		else{
			throw new PersonException(this);
		}
	
	}
	public String getPhone() {
		return phone_number;
	}
	public void setEmail(String newEmail) {
		email_address = newEmail;
	}
	public String getEmail() {
		return email_address;
	}

	/*
	 * Constructors No Arg Constructor
	 */
	public Person() {

	}

	/*
	 * Constructors Constructor with arguments
	 */

	public Person(String FirstName, String MiddleName, String LastName,
			Calendar DOB, String Address, String Phone_number, String Email){
		this.FirstName = FirstName;
		this.MiddleName = MiddleName;
		this.LastName = LastName;
		try {
			this.setDOB(DOB);
		} catch (PersonException e) {
			this.isValid = false;
			e.getPersonAge();
			e.printStackTrace();
		}
		this.address = Address;
		try {
			this.setPhone(Phone_number);
		} catch (PersonException e) {
			this.isValid = false;
			e.getPersonPhone();
			e.printStackTrace();
		}
		this.email_address = Email;
		
	}

	public void PrintName() {
		System.out.println(this.FirstName + ' ' + this.MiddleName + ' '
				+ this.LastName);
	}

	public void PrintDOB() {
		System.out.println(this.DOB);
	}

	public int PrintAge() {
		Calendar today = Calendar.getInstance();
		Calendar birthDate = this.DOB;

		int age = 0;
		if (birthDate.after(today)) {
			throw new IllegalArgumentException("Can't be born in the future");
		}
		age = today.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR);

		// If birth date is greater than todays date (after 2 days adjustment of
		// leap year) then decrement age one year
		if ((birthDate.get(Calendar.DAY_OF_YEAR)
				- today.get(Calendar.DAY_OF_YEAR) > 3)
				|| (birthDate.get(Calendar.MONTH) > today.get(Calendar.MONTH))) {
			age--;

			// If birth date and todays date are of same month and birth day of
			// month is greater than todays day of month then decrement age
		} else if ((birthDate.get(Calendar.MONTH) == today.get(Calendar.MONTH))
				&& (birthDate.get(Calendar.DAY_OF_MONTH) > today
						.get(Calendar.DAY_OF_MONTH))) {
			age--;
		}

		System.out.println("age is " + age);

		return age;

	}
}