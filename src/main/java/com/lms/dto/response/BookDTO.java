package com.lms.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BookDTO {

	private long id;
	
    private String title;
    
    private String authorName;
	
    private String publisher;
	
    private Integer yearOfPublication;
	
    private Integer totalCopies;
	
    private Integer availableCopies;
	
    @JsonIgnore
	private MemberDTO issuedTo;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public void setIssuedTo(MemberDTO issuedTo) {
		this.issuedTo = issuedTo;
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

	public MemberDTO getIssuedTo() {
		return issuedTo;
	}

	
    
}
