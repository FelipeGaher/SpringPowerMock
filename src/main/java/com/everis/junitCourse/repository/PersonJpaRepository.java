package com.everis.junitCourse.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.junitCourse.model.Person;


@Repository("personJpaRepository")
public interface PersonJpaRepository extends JpaRepository<Person, Serializable> {
	
	public abstract Person findByAge(int age);
	
	public abstract Person findByName(String name);
	
}
