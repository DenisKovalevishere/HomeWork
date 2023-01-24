package ru.kovalev.springcourse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.kovalev.springcourse.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer>{
	
	List<Person> findByName(String name);
	
	List<Person> findByNameOrderByAge(String name);
	
	List<Person> findByEmail(String email);
	
	List<Person> findByNameStartingWith(String startingWith);
	
	List<Person> findByNameOrEmail(String name, String email);
	
}
