package ru.kovalev.hibernate.film.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Movie")
public class Movie {

	@Id
	@Column(name="movie_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="year_of_production")
	private int yearOfProduction;
	
	@ManyToOne
	@JoinColumn(name="director_id", referencedColumnName = "director_id")
	private Director owner;
	
	public Movie() {}

	public Movie(String name, int yearOfProduction, Director owner) {
		this.name = name;
		this.yearOfProduction = yearOfProduction;
		this.owner=owner;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", name=" + name + ", yearOfProduction=" + yearOfProduction + "]";
	}

	public Director getOwner() {
		return owner;
	}

	public void setOwner(Director owner) {
		this.owner = owner;
	}
	
	
}
