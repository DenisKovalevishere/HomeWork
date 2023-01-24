package ru.kovalev.springcourse.FirstSecurityApp.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Table(name="person")
@Entity
public class Person {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message="Имя не должно быть пустым")
	@Size(min=2, max=100, message="Имя должно быть от 2 до 100 символов длинной")
	@Column(name="username")
	private String username;
	
	@Min(value=1900, message="Год рождения должен быть больше, чкм 1900")
	@Column(name="year_of_birth")
	private int yearOfBirth;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role")
	private String role;
	
	public Person() {}

	public Person(
			@NotEmpty(message = "Имя не должно быть пустым") @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длинной") String username,
			@Min(value = 1900, message = "Год рождения должен быть больше, чкм 1900") int yearOfBirth) {
		this.username = username;
		this.yearOfBirth = yearOfBirth;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", username=" + username + ", yearOfBirth=" + yearOfBirth + ", password=" + password
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, password, username, yearOfBirth);
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
		return id == other.id && Objects.equals(password, other.password) && Objects.equals(username, other.username)
				&& yearOfBirth == other.yearOfBirth;
	}
	
	
}
