package ru.kovalev.springcourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


import ru.kovalev.springcourse.models.Person;
import ru.kovalev.springcourse.services.PeopleService;

@Component
public class PersonValidator implements Validator{
	
	private final PeopleService peopleService;
		
	@Autowired
	public PersonValidator(PeopleService peopleService) {
		this.peopleService=peopleService ;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Person.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Person person = (Person) target;
		
//		if (personDAO.show(person.getEmail()).isPresent()) {
//			errors.rejectValue("email", "","This email is already taken");
//		}
		
	}
	
	

}
