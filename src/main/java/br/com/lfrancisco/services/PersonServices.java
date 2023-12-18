package br.com.lfrancisco.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lfrancisco.data.vo.v1.PersonVO;
import br.com.lfrancisco.exceptions.ResourceNotFoundException;
import br.com.lfrancisco.mapper.DozerMapper;
import br.com.lfrancisco.models.Person;
import br.com.lfrancisco.repositories.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	private PersonRepository personRepository;

	public PersonVO findById(Long id) {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for id: ".concat(id.toString())));

		return DozerMapper.parseObject(person, PersonVO.class);
	}

	public List<PersonVO> findAll() {
		return DozerMapper.parseListObject(personRepository.findAll(), PersonVO.class);
	}

	public PersonVO create(PersonVO person) {
		return DozerMapper.parseObject(personRepository.save(DozerMapper.parseObject(person, Person.class)),
				PersonVO.class);
	}

	public PersonVO update(PersonVO person) {
		Person entity = personRepository.findById(person.getId()).orElseThrow(
				() -> new ResourceNotFoundException("No records found for id: ".concat(person.getId().toString())));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
	}

	public void delete(Long id) {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for id: ".concat(id.toString())));

		personRepository.delete(person);
	}
}
