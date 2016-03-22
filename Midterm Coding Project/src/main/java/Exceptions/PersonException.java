package Exceptions;

import com.cisc181.core.Person;

public class PersonException extends Exception{
	
	/*
	 * Throw if persons age is > 100
	 * Throw if phone number not in proper format (###)-###-####
	 */
	
	private static final long serialVersionUID = 1L;
	private Person person;
	
	public PersonException(Person p){
		super();
		this.person = p;
	}
	public void getPersonAge(){
		System.out.print("ERROR: Date of birth entered is: "+this.person.getDOB());
		System.out.print("which is too old, date must be within 100 year");
	}
	public void getPersonPhone(){
		System.out.print("ERROR: phone number must be 10 digits long and of form");
		System.out.print("(###)-###-####");
	}
	
}
