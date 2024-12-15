package com.lms.dto.request;

import java.util.Date;

public class TransactionRequest {

	private long tranctionId;

	private long bookId;

	private long MemberId;

	private Date borrowDate;

	private Date returnDate;

	private Date dueDate;

	public long getTranctionId() {
		return tranctionId;
	}

	public void setTranctionId(Long tranctionId) {
		this.tranctionId = tranctionId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getMemberId() {
		return MemberId;
	}

	public void setMemberId(Long memberId) {
		MemberId = memberId;
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

}
