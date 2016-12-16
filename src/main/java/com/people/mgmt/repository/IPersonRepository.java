package com.people.mgmt.repository;

import java.util.List;

import com.people.mgmt.vo.Person;

public interface IPersonRepository 
{

	public List<Person> findAll();
	
	public List<Person> findPersonsBasedOnInputs(Person person);

	public void createPerson(Person person);

	void updatePerson(Person person);

	//public List<Person> findByFirstNameAndLastName(String firstName, String lastName);
}
