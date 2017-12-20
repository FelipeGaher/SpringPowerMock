package com.everis.junitCourse.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import com.everis.junitCourse.JunitCourseApplicationTests;

public class PersonServiceImpl05SpyVsMockTest extends JunitCourseApplicationTests {

	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule(); // Inicializa Mocks

	@SuppressWarnings({ "unchecked" })
	@Test
	public void whenCreateMock() {
		List<String> mockedList = mock(ArrayList.class);

		mockedList.add("one");
		verify(mockedList).add("one");

		assertEquals(0, mockedList.size());
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void whenCreateSpy() {
		List<String> spyList = spy(new ArrayList());

		spyList.add("one");
		verify(spyList).add("one");

		assertEquals(1, spyList.size());
	}

}
