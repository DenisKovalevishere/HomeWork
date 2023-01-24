package ru.kovalev.springcource.Project2Boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	public LibraryController() {}

	@GetMapping
	public String libraryPage() {
		return "library/library";
	}
}
