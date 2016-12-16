package com.people.mgmt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.people.mgmt.service.IPersonService;
import com.people.mgmt.vo.Person;

@RequestMapping(value = "person")
@Controller
public class PersonController {

	@Autowired
	private IPersonService personService;

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public ResponseEntity<List<Person>> getAllPersons(HttpServletRequest request, HttpServletResponse response) {

		List<Person> persons = personService.getAllPeople();

		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

	@RequestMapping(value = "/search", method = { RequestMethod.GET })
	public ResponseEntity<List<Person>> getPersonsBasedOnInputs(HttpServletRequest request,
			HttpServletResponse response, @RequestParam(value = "firstName", required = false) String firstName,
			@RequestParam(value = "lastName", required = false) String lastName) {

		List<Person> persons = personService.getPerson(firstName, lastName);

		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/search", method = { RequestMethod.POST })
	public ResponseEntity<List<Person>> getPersonsBasedOnInputsPost(HttpServletRequest request,
			HttpServletResponse response, @RequestBody Person person) {

		List<Person> persons = personService.getPerson(person);

		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = { RequestMethod.POST })
	public ResponseEntity<Person> createPerson(HttpServletRequest request,
			HttpServletResponse response, @RequestBody Person person) {

		personService.createPerson(person);

		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = { RequestMethod.PUT })
	public ResponseEntity<Person> updatePerson(HttpServletRequest request,
			HttpServletResponse response, @RequestBody Person person) {

		personService.updatePerson(person);

		return new ResponseEntity<Person>(person,HttpStatus.OK);
	}

}
