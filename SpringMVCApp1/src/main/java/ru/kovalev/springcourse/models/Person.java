package ru.kovalev.springcourse.models;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="person")
public class Person {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Name should not be empty")
	@Size(min=2, max=30, message = "Name should be between 2 and 30 character")
	@Column(name="name")
	private String name;
	
	@Min(value = 1, message = "Age should be greater than 1")
	@Column(name="age")
	private int age;
	
	@NotEmpty(message = "Email should not be empty")
	@Email(message = "Email shold be valid")
	@Column(name="email")
	private String email;
	
	@Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your address should be in this format: Country, City, Postal Code (6 digits)")
	@Column(name="address")
	private String address;

	@OneToMany(mappedBy = "owner")
	private List<Item> items;
	
	@Column(name="date_of_birth")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfBirth;
	
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Enumerated(EnumType.STRING)
	@Column(name="mood")
	private Mood mood;
	

	public Person(String name, int age, String email, String address, Date dateOfBirth) {
		this.name = name;
		this.age = age;
		this.email=email;
		this.address=address;
		this.dateOfBirth=dateOfBirth;
		
		
	}
	
	public Person() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", address=" + address
				+ ", dateOfBirth=" + dateOfBirth + "]";
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Mood getMood() {
		return mood;
	}

	public void setMood(Mood mood) {
		this.mood = mood;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, age, createdAt, dateOfBirth, email, id, mood, name);
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
		return Objects.equals(address, other.address) && age == other.age && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(dateOfBirth, other.dateOfBirth) && Objects.equals(email, other.email)
				&& id == other.id && mood == other.mood && Objects.equals(name, other.name);
	}
	

}
