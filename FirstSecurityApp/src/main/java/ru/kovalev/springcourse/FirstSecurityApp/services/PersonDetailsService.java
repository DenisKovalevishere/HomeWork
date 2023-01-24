package ru.kovalev.springcourse.FirstSecurityApp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.kovalev.springcourse.FirstSecurityApp.models.Person;
import ru.kovalev.springcourse.FirstSecurityApp.repositories.PeopleRepository;
import ru.kovalev.springcourse.FirstSecurityApp.security.PersonDetails;

@Service
public class PersonDetailsService implements UserDetailsService{

	private final PeopleRepository peopleRepository;

	@Autowired
	public PersonDetailsService(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Person> person = peopleRepository.findByUsername(username);
		
		if (person.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		}
		return new PersonDetails(person.get());
	}
	
	
	
}
