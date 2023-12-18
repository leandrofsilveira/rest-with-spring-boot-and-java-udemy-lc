package br.com.lfrancisco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lfrancisco.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{}