package com.everis.junitCourse.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.everis.junitCourse.model.Person;
import com.everis.junitCourse.service.PersonService;

@Controller
@RequestMapping("/persona")
public class PersonController {

	public static final String PERSONA_VIEW = "persona";
	private static final Log LOGGER = LogFactory.getLog(PersonController.class);

	@Autowired
	@Qualifier("persona")
	private PersonService serv;
	
	@GetMapping("/listar")
	public ModelAndView getPeople(@RequestParam(name = "flag", required=false, defaultValue="N") String flag) {
		ModelAndView mav = new ModelAndView(PERSONA_VIEW);
		mav.addObject("person", new Person());
		mav.addObject("people", serv.getListPeople(flag));
		LOGGER.info("-The real Controller-");
		return mav;
	}
	
	@PostMapping("/add")
	public String addPerson(@ModelAttribute("person") Person person) {
		LOGGER.info("Call: addPerson()");
		serv.addPerson(person);
		return "redirect:/persona/listar";
	}
}
