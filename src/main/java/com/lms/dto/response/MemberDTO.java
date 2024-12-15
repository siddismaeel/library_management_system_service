package com.lms.dto.response;

import java.util.Date;
import java.util.List;

public class MemberDTO {
	
	private long id;
	
    private String firstName;
	
    private String lastName;
	
    private String email;
	
    private String phoneNumber;
	
    private Date membershipDate;
	
	private List<BookDTO> issuedBooks;

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getMembershipDate() {
		return membershipDate;
	}

	public void setMembershipDate(Date membershipDate) {
		this.membershipDate = membershipDate;
	}

	public List<BookDTO> getIssuedBooks() {
		return issuedBooks;
	}

	public void setIssuedBooks(List<BookDTO> issuedBooks) {
		this.issuedBooks = issuedBooks;
	}
	
	
}
