package ru.kovalev.hibernate.film.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Director")
public class Director {

	@Id
	@Column(name="director_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int directorId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private int age;
	
	@OneToMany(mappedBy = "owner")
	private List<Movie> movies;
	
	public Director() {}


	public Director(String name, int age) {
		this.name = name;
		this.age = age;
	}


	public int getDirectorId() {
		return directorId;
	}


	public void setDirectorId(int directorId) {
		this.directorId = directorId;
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


	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", name=" + name + ", age=" + age + "]";
	}


	public List<Movie> getMovies() {
		return movies;
	}


	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	
	
}
