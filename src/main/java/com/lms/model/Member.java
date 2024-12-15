package com.lms.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="member")
public class Member extends BaseModel{
	
	@Column(name="f_name")
    private String firstName;
	@Column(name="l_name")
	
    private String lastName;
	@Column(name="email")
    private String email;
	
	@Column(name="phone")
    private String phoneNumber;
	
	@Column(name="membership_date")
    private Date membershipDate;
	
	@ManyToMany 
	Set<Book> issuedBooks = new HashSet<>();

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

	public Set<Book> getIssuedBooks() {
		return issuedBooks;
	}

	public void setIssuedBooks(Set<Book> issuedBooks) {
		this.issuedBooks = issuedBooks;
	}
	
    		
    

}
