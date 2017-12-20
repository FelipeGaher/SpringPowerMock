package com.everis.junitCourse.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.everis.junitCourse.JunitCourseApplicationTests;

@RunWith(PowerMockRunner.class)
@PrepareForTest(NetworkReader.class)
public class PersonServiceImpl06PowerMockTest extends JunitCourseApplicationTests {

	@Test
	public void testSomething() {
		mockStatic(NetworkReader.class);
		when(NetworkReader.getLocalHostname()).thenReturn("localhost");

		String host = NetworkReader.getLocalHostname();

		assertEquals("localhost", host);
	}
}
