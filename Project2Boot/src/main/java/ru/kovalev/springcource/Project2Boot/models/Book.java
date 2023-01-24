package ru.kovalev.springcource.Project2Boot.models;

import java.util.Date;
import java.util.Objects;



import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty(message = "Title book should not be empty")
	@Size(min = 2, max = 75, message="Title should be between 2 and 75 characters")
	@Column(name="title")
	private String title;
	
	@NotEmpty(message = "Author book should not be empty")
	@Size(min = 2, max = 75, message="Author should be between 2 and 75 characters")
	@Column(name="author")
	private String author;
	
	@DateTimeFormat(pattern = "yyyy")
	@Column(name="year")
	private int year;
	
	@Column(name="created_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@ManyToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person owner;
	
	@Transient
	private boolean expired;
	
	
	public Book (String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	public Book() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	
	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, createdAt, id, title, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(createdAt, other.createdAt) && id == other.id
				&& Objects.equals(title, other.title) && year == other.year;
	}

	@Override
	public String toString() {
		return "Book is:  [id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + "]";
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	

	
	
}
