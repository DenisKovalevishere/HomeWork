package ru.kovalev.springcource.Project2Boot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.kovalev.springcource.Project2Boot.models.Book;



public interface BooksRepository extends JpaRepository<Book, Integer>{
	
	List<Book> findByTitleStartingWith(String title);
	
	
}
