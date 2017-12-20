package com.everis.junitCourse.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.everis.junitCourse.model.Person;
import com.everis.junitCourse.repository.PersonJpaRepository;

@Service("persona")
public class PersonServiceImpl implements PersonService {

	private static final Log LOGGER = LogFactory.getLog(PersonServiceImpl.class);

	@Autowired
	@Qualifier("personJpaRepository")
	public PersonJpaRepository personJpaRepository;

	@Override
	public List<Person> getListPeople(String flag) {
		List<Person> people = new ArrayList<Person>();

		if (flag != null && flag.equals("S")) {
			return null;
		}
		people = personJpaRepository.findAll();

		LOGGER.info("-Service completed-");
		return people;
	}

	@Override
	public Person addPerson(Person person) {
		person = personJpaRepository.save(person);
		LOGGER.info("-Service completed-");
		return person;
	}

	@Override
	public void deletePerson(Person person) {
		try {
			personJpaRepository.delete(person);
			LOGGER.info("-Service completed-");
		} catch (Exception e) {
			LOGGER.error("EXCEPTION: " + e.getMessage());
			LOGGER.error("-Service NOT completed-");
		}
	}
	
	@Override
	public Person playWithPeople(int age) {


		Person p2 = personJpaRepository.findByAge(age);

		LOGGER.info("-Service completed-");
		return p2;
	}
}
