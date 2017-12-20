package com.everis.junitCourse.extra;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExecutionProcedureJunit {
	
   @BeforeClass
   public static void beforeClass() {
      System.out.println("Before class - Primero");
   }

   @AfterClass
   public static void  afterClass() {
      System.out.println("After class - Ultimo");
   }

   @Before
   public void before() {
      System.out.println("Before - antes tests cases");
   }
	
   @After
   public void after() {
      System.out.println("After - despues de un test case");
   }
	
   //test case 1
   @Test
   public void testCase1() {
      System.out.println("Test case 1");
   }

   //test case 2
   @Test
   public void testCase2() {
      System.out.println("Test case 2");
   }
}