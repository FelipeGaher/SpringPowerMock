package com.everis.junitCourse.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.everis.junitCourse.JunitCourseApplicationTests;
import com.everis.junitCourse.model.Person;

public class PersonServiceImpl04SpyTest extends JunitCourseApplicationTests {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule(); // Inicializa Mocks

	@Spy
	List<String> spyList = new ArrayList<String>();

	Person person;
	List<Person> personas;

	@Test
	public void annotationThenObjectIsSpied() {
		spyList.add("one");
		spyList.add("two");

		verify(spyList).add("one");
		verify(spyList).add("two");

		assertEquals(2, spyList.size());
	}
	
	
	@Test
	@Ignore
	public void testLinkedListSpyNok() {
		List<String> list = new LinkedList<>();
		List<String> spy = spy(list);

		// el metodo real es llamado, y lanza error al estar vacia la lista
		when(spy.get(0)).thenReturn("foo");

		assertEquals("foo", spy.get(0));
	}

	@Test
	public void testLinkedListSpyOk() {
		List<String> list = new LinkedList<>();
		List<String> spy = spy(list);

		// You have to use doReturn() for stubbing
		doReturn("foo").when(spy).get(0);

		when(spy.size()).thenReturn(100);

		assertEquals("foo", spy.get(0));
		assertEquals(100, spy.size());

	}
}
