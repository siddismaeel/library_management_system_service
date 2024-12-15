package com.lms.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="book")
public class Book extends BaseModel{

	@Column(name="boo_title")
    private String title;
	
	@Column(name="author_name")
    private String authorName;
	
	@Column(name="publisher")
    private String publisher;
	
	@Column(name="year_of_publication")
    private Integer yearOfPublication;
	
	@Column(name="total_copies")
    private Integer totalCopies;
	
	@Column(name="available_copies")
    private Integer availableCopies;
	
	@Column(name="issued_copies")
	private Integer issuedCopies;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Integer getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(Integer yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	public Integer getTotalCopies() {
		return totalCopies;
	}

	public void setTotalCopies(Integer totalCopies) {
		this.totalCopies = totalCopies;
	}

	public Integer getAvailableCopies() {
		return availableCopies;
	}

	public void setAvailableCopies(Integer availableCopies) {
		this.availableCopies = availableCopies;
	}
	
	public Integer getIssuedCopies() {
		return issuedCopies;
	}

	public void setIssuedCopies(Integer issuedCopies) {
		this.issuedCopies = issuedCopies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(publisher, title, yearOfPublication);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(publisher, other.publisher) && Objects.equals(title, other.title)
				&& Objects.equals(yearOfPublication, other.yearOfPublication);
	}

	
}
