package ru.kovalev.springcourse.FirstSecurityApp.util;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ru.kovalev.springcourse.FirstSecurityApp.models.Person;
import ru.kovalev.springcourse.FirstSecurityApp.services.PersonDetailsService;



@Component
public class PersonValidator implements Validator{

	private final PersonDetailsService personDetailsService;

	@Autowired
	public PersonValidator(PersonDetailsService personDetailsService) {
		this.personDetailsService = personDetailsService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Person person = (Person) target;
		try {
		personDetailsService.loadUserByUsername(person.getUsername());
		} catch (UsernameNotFoundException ignored) {
			return;
		}
		
		errors.rejectValue("username", "", "Person with username has present");
	}



}
