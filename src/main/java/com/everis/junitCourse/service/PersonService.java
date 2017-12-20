package com.everis.junitCourse.service;

import java.util.List;

import com.everis.junitCourse.model.Person;

public interface PersonService {

	public abstract List<Person> getListPeople(String flag);	
	
	public abstract Person addPerson(Person person);

	public void deletePerson(Person person);
	
	public Person playWithPeople(int age);
	
}
