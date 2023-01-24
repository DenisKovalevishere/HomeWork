package ru.kovalev.springcourse.FirstSecurityApp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.kovalev.springcourse.FirstSecurityApp.models.Person;

public interface PeopleRepository extends JpaRepository<Person, Integer>{

	
	Optional<Person> findByUsername(String username);
	
	
}
