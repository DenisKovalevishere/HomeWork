package ru.kovalev.springcource.Project2Boot.repositories;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.kovalev.springcource.Project2Boot.models.Person;


public interface PeopleRepository extends JpaRepository<Person, Integer>{
	Optional<Person> findByFullName(String fullName);

}
