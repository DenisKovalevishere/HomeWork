package ru.kovalev.springcource.Project2Boot.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.kovalev.springcource.Project2Boot.models.Book;
import ru.kovalev.springcource.Project2Boot.models.Person;
import ru.kovalev.springcource.Project2Boot.repositories.BooksRepository;


@Service
@Transactional(readOnly = true)
public class BooksService {
	
	private final BooksRepository booksRepository;


	@Autowired
	public BooksService(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}
	
	public List<Book> findAll(boolean sortByYear){
		if (sortByYear) {
			return booksRepository.findAll(Sort.by("year"));
		} else {
			return booksRepository.findAll();
		}
	}
	
	public List<Book> findWithPagination(Integer page, Integer booksPerPage, boolean sortByYear) {
		if(sortByYear) {
			return booksRepository.findAll(PageRequest.of(page, booksPerPage, Sort.by("year"))).getContent();
		} else {
			return booksRepository.findAll(PageRequest.of(page, booksPerPage)).getContent();
		}
	}
	
	
	public Book findOne(int id) {
		Optional<Book> foundBook = booksRepository.findById(id);
		return foundBook.orElse(null);
	}
	
	public List<Book> searchByTitle(String query) {
		return booksRepository.findByTitleStartingWith(query);
	}
	
	@Transactional
	public void save(Book book) {
		booksRepository.save(book);
	}
	
	@Transactional
	public void update(int id, Book updatedBook) {
		Book bookToBeUpdated = booksRepository.findById(id).get();
		
		updatedBook.setId(id);
		updatedBook.setOwner(bookToBeUpdated.getOwner());
		
		booksRepository.save(updatedBook);
	}
	
	@Transactional
	public void delete(int id) {
		booksRepository.deleteById(id);
	}
	
	
	@Transactional
	public void release (int id) {
		Book foundBook = booksRepository.findById(id).orElse(null);
		foundBook.setOwner(null);
		foundBook.setCreatedAt(null);
		booksRepository.save(foundBook);
	}
	
	@Transactional
	public void assign(int id, Person selectedPerson) {
		Book foundBook = booksRepository.findById(id).orElse(null);
		foundBook.setOwner(selectedPerson);
		foundBook.setCreatedAt(new Date());
		booksRepository.save(foundBook);
	}
	
	public Person getBookOwner(int id) {
		return booksRepository.findById(id).map(Book::getOwner).orElse(null);
	}
	
}
