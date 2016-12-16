package com.people.mgmt.service;

import java.util.List;

import com.people.mgmt.vo.Person;

public interface IPersonService {

	public boolean createPerson(Person person);
	public List<Person> getAllPeople();
	public List<Person> getPerson(String firstName, String lastName);
	public boolean updatePerson(Person person);
	public List<Person> getPerson(Person person);
}
