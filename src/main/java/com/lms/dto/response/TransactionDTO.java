package com.lms.dto.response;

import java.util.Date;

import com.lms.enums.TransactionTypes;

public class TransactionDTO {
	
	private Long id;
	
    private BookDTO book;
	
    private MemberDTO issueTo;
	
    private Date borrowDate;

    private Date returnDate;
    
    private Date dueDate;

    private TransactionTypes transactionType;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BookDTO getBook() {
		return book;
	}

	public void setBook(BookDTO book) {
		this.book = book;
	}

	public MemberDTO getIssueTo() {
		return issueTo;
	}

	public void setIssueTo(MemberDTO issueTo) {
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
