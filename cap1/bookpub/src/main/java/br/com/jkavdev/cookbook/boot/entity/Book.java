package br.com.jkavdev.cookbook.boot.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	private String isbn;
	private String title;
	private String description;

	@ManyToOne
	private Author author;
	@ManyToOne
	private Publisher publisher;

	@ManyToMany
	private List<Reviewers> reviewers;

	protected Book() {}

	public Book(String isbn, String title, String description, Author author, Publisher publisher) {
		this.isbn = isbn;
		this.title = title;
		this.description = description;
		this.author = author;
		this.publisher = publisher;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Reviewers> getReviewers() {
		return reviewers;
	}

	public void setReviewers(List<Reviewers> reviewers) {
		this.reviewers = reviewers;
	}

}
