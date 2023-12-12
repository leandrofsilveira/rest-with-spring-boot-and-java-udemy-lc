package br.com.lfrancisco.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.lfrancisco.models.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	public Person findById(String id) {

		logger.info("Finding person by id");

		Person person = new Person();

		person.setId(counter.getAndIncrement());
		person.setFirstName("Leandro");
		person.setLastName("Francisco");
		person.setAddress("Jaraguá do Sul - Santa Catarina - Brasil");
		person.setGender("Male");

		return person;
	}

	public List<Person> findAll() {

		List<Person> personList = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			personList.add(person);
		}

		return personList;
	}

	public Person create(Person person) {
		logger.info("Creating person");

		return person;
	}

	public Person update(Person person) {
		logger.info("Updating person");

		return person;
	}

	public Person delete(String id) {
		logger.info("Deleting person");

		return null;
	}

	private Person mockPerson(int i) {

		Person person = new Person();

		person.setId(counter.getAndIncrement());
		person.setFirstName("Person " + i);
		person.setLastName("Last P" + i);
		person.setAddress("Address " + i);
		person.setGender("Male");

		return person;

	}

}
