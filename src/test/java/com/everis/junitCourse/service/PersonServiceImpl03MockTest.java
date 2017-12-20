package com.everis.junitCourse.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.everis.junitCourse.JunitCourseApplicationTests;
import com.everis.junitCourse.model.Person;
import com.everis.junitCourse.repository.PersonJpaRepository;

public class PersonServiceImpl03MockTest extends JunitCourseApplicationTests {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule(); // Inicializa Mocks

	@InjectMocks
	@Autowired
	@Qualifier("persona")
	PersonService personaService = new PersonServiceImpl();

	@Mock
	@Qualifier("personJpaRepository")
	PersonJpaRepository personJpaRepository;

	Person person;
	List<Person> personas;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this); // Inicializa Mocks

		personas = new ArrayList<Person>();
		person = new Person();
		person.setAge(12);
		person.setName("Arya");
		personas.add(person);

	}

	@Test
	public void getListPeopleOk() {

		Mockito.when(personJpaRepository.findAll()).thenReturn(personas);

		personas = personaService.getListPeople("N");

		assertNotNull(personas);

		verify(personJpaRepository, times(1)).findAll();
		assertEquals(personas.get(0).getAge(), 12);
		assertEquals(personas.get(0).getName(), "Arya");

	}

	@Test
	public void getListPeopleOk2() {

		Mockito.doReturn(personas).when(personJpaRepository).findAll();

		personas = personaService.getListPeople("N");

		assertNotNull(personas);

		verify(personJpaRepository, times(1)).findAll();
		assertEquals(personas.get(0).getAge(), 12);
		assertEquals(personas.get(0).getName(), "Arya");

	}

	@Test
	public void deletePersonOk() {

		Person p1 = new Person();

		doNothing().when(personJpaRepository).delete(any(Person.class));

		personaService.deletePerson(person);

		verify(personJpaRepository, times(1)).delete(any(Person.class));

		assertNotNull(p1);
	}

	@Test
	public void deletePersonExceptionOk() {

		Person p1 = new Person();

		doThrow(new HibernateException("ERROR CREADO POR MOCK!!!!")).when(personJpaRepository)
				.delete(any(Person.class));

		personaService.deletePerson(person);

		verify(personJpaRepository, times(1)).delete(any(Person.class));

		assertNotNull(p1);
	}

	@Test
	public void getListPeopleOk3() {

		
		when(personJpaRepository.findByAge(any(Integer.class))).thenAnswer(i -> {
			Person p = new Person();
			p.setAge(11);
			p.setName("CHAN");
		    return p;
		});

		Person person = personaService.playWithPeople(1);

		assertNotNull(person);

		verify(personJpaRepository, times(1)).findByAge(anyInt());

		assertEquals(person.getAge(), 11);
		assertEquals(person.getName(), "CHAN");

	}
}