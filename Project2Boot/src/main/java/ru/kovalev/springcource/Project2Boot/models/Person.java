package ru.kovalev.springcource.Project2Boot.models;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="person")
public class Person {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="Name should not be empty")
	@Size(min = 2, max = 75, message="Name should be between 2 and 75 characters")
	@Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+ [A-Z]\\w+", message="Your full name should be in this format: Name Surname Secondname")
	@Column(name="full_name")
	private String fullName;
	
	@Min(value = 1920, message="Year of birth should be greater than 1920")
	@Max(value = 2022, message="Year of birth should be more than 2022")
	@DateTimeFormat(pattern = "yyyy")
	@Column(name="year_of_birth")
	private int yearOfBirth;
	
	@OneToMany(mappedBy = "owner")
	private List<Book> books;
	
	
	public Person(String fullName, int yearOfBirth) {
		this.fullName = fullName;
		this.yearOfBirth = yearOfBirth;
	}
	
	public Person() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fullName, id, yearOfBirth);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(fullName, other.fullName) && id == other.id && yearOfBirth == other.yearOfBirth;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", fullName=" + fullName + ", yearOfBirth=" + yearOfBirth + "]";
	}
	
	
}
