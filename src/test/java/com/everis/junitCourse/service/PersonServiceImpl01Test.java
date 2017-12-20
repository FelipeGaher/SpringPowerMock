package com.everis.junitCourse.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.everis.junitCourse.JunitCourseApplicationTests;
import com.everis.junitCourse.model.Person;

public class PersonServiceImpl01Test extends JunitCourseApplicationTests{

	@Autowired
	@Qualifier("persona")
	PersonService personaService;
	
	@Test
	public void personaListarOk() {
		
		List<Person> personas= new ArrayList<Person>();
		
		personas = personaService.getListPeople("N");
		
		assertNotNull(personas);
		
		assertEquals(personas.get(0).getAge(), 18);
		
	}
	
	@Test
	public void personaListarNok() {
		
		List<Person> personas= new ArrayList<Person>();
		
		personas = personaService.getListPeople("S");
		
		assertNull(personas);
		
	}
	
}
