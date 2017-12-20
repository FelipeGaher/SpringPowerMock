package com.everis.junitCourse.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.TransactionSystemException;

import com.everis.junitCourse.JunitCourseApplicationTests;
import com.everis.junitCourse.model.Person;

public class PersonServiceImpl02ExceptionTest extends JunitCourseApplicationTests {

	@Autowired
	@Qualifier("persona")
	PersonService personaService;

	/* Anotacion rule para probar excepciones especificas en los tests */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/**
	 * With JUnit rule
	 */
	@Test
	public void testJunitRule() throws IndexOutOfBoundsException {
		List<Object> list = new ArrayList<Object>();

		/* Se agrega la excepcion a esperar */
		thrown.expect(IndexOutOfBoundsException.class);

		/* Se ejecuta el metodo */
		list.get(0);
	}

	/**
	 * With annotation
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testJunitAnnotation() {

		new ArrayList<Object>().get(0);

	}

	/**
	 * With annotation
	 */
	@Test(expected = TransactionSystemException.class)
	public void testJunitAnnotation2() {

		Person person = new Person();
		person.setAge(-1);
		person.setName("Arya");

		personaService.addPerson(person);

	}
}
