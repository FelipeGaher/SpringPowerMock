package com.everis.junitCourse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PERSON", schema="ESQUEMA")
public class Person {

	@NotNull
	@Size(min=2, max=20)
	@Id
	@Column(name = "NAME")
	private String name;
	
	@NotNull
	@Min(0)
	@Column(name = "AGE")
	private int age;

	public Person() {
		
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
