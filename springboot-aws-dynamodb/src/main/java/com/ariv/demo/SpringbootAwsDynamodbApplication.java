package com.ariv.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ariv.demo.entity.Person;
import com.ariv.demo.repository.PersonRepository;

@SpringBootApplication
@RestController
public class SpringbootAwsDynamodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsDynamodbApplication.class, args);
	}

	@Autowired
	private PersonRepository personRepository;

	@PostMapping("/savePerson")
	public Person savePerson(Person person) {
		return personRepository.addPerson(person);
	}

	@GetMapping("/getPerson/{personId}")
	public Person getPerson(@PathVariable String personId) {
		return personRepository.findPersonById(personId);
	}

	@DeleteMapping("deletePerson")
	public String deletePerson(@RequestBody Person person) {
		return personRepository.deletePerson(person);
	}

	@PutMapping
	public String updatePerson(@RequestBody Person person) {
		return personRepository.updatePerson(person);
	}
}
