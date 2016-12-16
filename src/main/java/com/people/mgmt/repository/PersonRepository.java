package com.people.mgmt.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.people.mgmt.vo.Person;

@Repository
public class PersonRepository implements IPersonRepository{

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public List<Person> findAll() {
		List<Person> persons = mongoTemplate.findAll(Person.class);
		return persons;
	}

	@Override
	public List<Person> findPersonsBasedOnInputs(Person person) {
		Query query = new Query();
		if(person.getFirstName() != null){
		query.addCriteria(Criteria.where("firstname").regex(person.getFirstName()));
		}
		else if(person.getLastName() != null){
		query.addCriteria(Criteria.where("lastname").regex(person.getLastName()));
		}
		List<Person> persons = mongoTemplate.find(query, Person.class);

		return persons;
	}

	@Override
	public void createPerson(Person person) {
		
		mongoTemplate.insert(person);
	}
	
	@Override
	public void updatePerson(Person person) {
		
		Query query = new Query();
		if(person.getFirstName() != null){
		query.addCriteria(Criteria.where("firstname").is(person.getFirstName()));
		}
		else if(person.getLastName() != null){
		query.addCriteria(Criteria.where("lastname").is(person.getLastName()));
		}
		Update update = new Update();
		update.set("age", person.getAge());
		update.set("work", person.getWork());
		mongoTemplate.findAndModify(query, update , Person.class);
	}

	

}
