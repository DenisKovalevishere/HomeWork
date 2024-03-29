package ru.kovalev.springcourse.FirstSecurityApp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import javax.validation.Valid;

import ru.kovalev.springcourse.FirstSecurityApp.dto.AuthenticationDTO;
import ru.kovalev.springcourse.FirstSecurityApp.dto.PersonDTO;
import ru.kovalev.springcourse.FirstSecurityApp.models.Person;
import ru.kovalev.springcourse.FirstSecurityApp.security.JWTUtil;
import ru.kovalev.springcourse.FirstSecurityApp.services.RegistrationService;
import ru.kovalev.springcourse.FirstSecurityApp.util.PersonValidator;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final PersonValidator personValidator;
	private final RegistrationService registrationService;
	private final JWTUtil jwtUtil;
	private final ModelMapper modelMapper;
	private final AuthenticationManager authenticationManager;
	
	@Autowired
	public AuthController(PersonValidator personValidator, RegistrationService registrationService, JWTUtil jwtUtil, ModelMapper modelMapper, AuthenticationManager authenticationManager) {
		this.personValidator = personValidator;
		this.registrationService = registrationService;
		this.jwtUtil = jwtUtil;
		this.modelMapper = modelMapper;
		this.authenticationManager = authenticationManager;
	}

//	@GetMapping("/login")
//	public String loginPage() {
//		return "auth/login";
//	}
//	
//	@GetMapping("/registration")
//	public String registrationPage(@ModelAttribute("person") Person person) {	
//		return "auth/registration";
//	}
	
	@PostMapping("/registration")
	public Map<String, String> performRegistration(@RequestBody @Valid PersonDTO personDTO, 
			BindingResult bindingResult) {
		
		Person person = convertToPerson(personDTO);
		
		personValidator.validate(person, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return Map.of("message", "Error:");
		}
		registrationService.register(person);
		
		String token = jwtUtil.generateToken(person.getUsername());
		return Map.of("jwt-token", token);
	}
	
	@PostMapping("/login")
	public Map<String, String> perfrormLogin(@RequestBody AuthenticationDTO authenticationDTO){
		UsernamePasswordAuthenticationToken authInputToken = 
				new UsernamePasswordAuthenticationToken(authenticationDTO.getUsername(), 
						authenticationDTO.getPassword());
		try {
		authenticationManager.authenticate(authInputToken);
		} catch (BadCredentialsException e){
			return Map.of("message", "Incorrect credentials1!");
		}
		
		String token = jwtUtil.generateToken(authenticationDTO.getUsername());
		return Map.of("jwt-token", token);
	}
	
	public Person convertToPerson(PersonDTO personDTO) {
		return this.modelMapper.map(personDTO, Person.class);
	}
}
