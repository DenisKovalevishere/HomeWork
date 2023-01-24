package ru.kovalev.springcource.dao;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import javax.persistence.EntityManager;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Component;
//
//import ru.kovalev.springcource.models.Book;
//import ru.kovalev.springcource.models.Person;
//
//@Component
//public class PersonDAO {


//	private final JdbcTemplate jdbcTemplate;
//	
//	@Autowired
//	public PersonDAO(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}
//
//	public List<Person> index(){
//		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<>(Person.class));
//	}
//	
//	public Optional<Person> show(String fullName) {
//		return jdbcTemplate.query("select * from person where full_name = ?", new Object[] {fullName},
//				new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
//	}
//	
//	public Person show(int id) {
//		return jdbcTemplate.query("select * from person where id = ?", new Object[] {id},
//				new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
//	}
//	
//	public void save(Person person) {
//		jdbcTemplate.update("insert into person(full_name, year_of_birth) values (?,?)", 
//				person.getFullName(), person.getYearOfBirth());
//	}
//
//	public void update(int id, Person updatedPerson) {
//		jdbcTemplate.update("update person set full_name = ?, year_of_birth = ? where id = ?", 
//				updatedPerson.getFullName(), updatedPerson.getYearOfBirth(), id);
//	}
//	
//	public void delete(int id) {
//		jdbcTemplate.update("delete from person where id = ?", id);
//	}
//	
//	public List<Book> getBooksByPersonId(int id) {
//		return jdbcTemplate.query("select * from book where person_id = ?", new Object[] {id},
//				new BeanPropertyRowMapper<>(Book.class));
//	}
//	private final EntityManager entityManager;
//
//	@Autowired
//	public PersonDAO(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}
//	
//	public Set<Book> getBooksByPersonId(int id){
//		Set<Book> books = new HashSet<Book>(entityManager.createQuery("select b from Book where person_id = ").getResultList());
//		return books;
//	}
//}
