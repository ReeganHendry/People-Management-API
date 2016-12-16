package com.people.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people.mgmt.repository.IPersonRepository;
import com.people.mgmt.vo.Person;
@Service
public class PersonService implements IPersonService{

	@Autowired
	private IPersonRepository personRepository;
	
	@Override
	public boolean createPerson(Person person) {

		personRepository.createPerson(person);
		return false;
	}

	@Override
	public List<Person> getAllPeople() {
		List<Person> persons = personRepository.findAll();
		
		return persons;
	}

	@Override
	public List<Person> getPerson(String firstName, String lastName) {
		// TODO Auto-generated method stub
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		List<Person> persons = personRepository.findPersonsBasedOnInputs(person);
		
		return persons;
	}

	@Override
	public boolean updatePerson(Person person) {
		personRepository.updatePerson(person);
		return true;
	}

	@Override
	public List<Person> getPerson(Person person) {
		// TODO Auto-generated method stub
		List<Person> persons = personRepository.findPersonsBasedOnInputs(person);
		return persons;
	}

}
