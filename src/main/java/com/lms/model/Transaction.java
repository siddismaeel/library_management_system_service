package com.lms.model;

import java.util.Date;

import com.lms.enums.TransactionTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="transaction")
public class Transaction extends BaseModel{

	@ManyToOne
	@JoinColumn(name="book_id", unique=false) 
    private Book book; 
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="memberId", unique=false)
    private Member issueTo; 
	
	@Column(name="borrow_date")
    private Date borrowDate;
	
	@Column(name="return_date")
    private Date returnDate;
	
	@Column(name="due_date")
    private Date dueDate;
	
	@Enumerated
	private TransactionTypes transactionType;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getIssueTo() {
		return issueTo;
	}

	public void setIssueTo(Member issueTo) {
		this.issueTo = issueTo;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public TransactionTypes getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionTypes transactionType) {
		this.transactionType = transactionType;
	}
	
    
	
	
    
}
