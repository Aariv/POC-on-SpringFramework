package com.ariv.demo.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.ariv.demo.entity.Person;

@Repository
public class PersonRepository {


	@Autowired
	private DynamoDBMapper dynamoDBMapper;
	
	public Person addPerson(Person person) {
		dynamoDBMapper.save(person);
		return person;
	}
	
	public Person findPersonById(String personId) {
		return dynamoDBMapper.load(Person.class, personId);
	}
	
	public String deletePerson(Person person) {
		dynamoDBMapper.delete(person);
		
		return "Person deleted";
	}
	
	public String updatePerson(Person person) {
		dynamoDBMapper.save(person, buildExpression(person));
		return "Updated Success";
	}

	private DynamoDBSaveExpression buildExpression(Person person) {
		DynamoDBSaveExpression dbse = new DynamoDBSaveExpression();
		Map<String, ExpectedAttributeValue> expectedMap = new HashMap<String, ExpectedAttributeValue>();
		expectedMap.put("personId", new ExpectedAttributeValue(new AttributeValue().withS(person.getPersonId())));
		dbse.setExpected(expectedMap);
		return dbse;
	}
}
