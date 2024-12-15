package com.lms.dto.response;

public class DashboardDTO {
	
	private long totalMembers;
	private long totalBooks;
	private long totalIssued;
	private long availableBooks;
	
	
	public long getTotalMembers() {
		return totalMembers;
	}
	public void setTotalMembers(long totalMembers) {
		this.totalMembers = totalMembers;
	}
	public long getTotalBooks() {
		return totalBooks;
	}
	public void setTotalBooks(long totalBooks) {
		this.totalBooks = totalBooks;
	}
	public long getTotalIssued() {
		return totalIssued;
	}
	public void setTotalIssued(long totalIssued) {
		this.totalIssued = totalIssued;
	}
	public long getAvailableBooks() {
		return availableBooks;
	}
	public void setAvailableBooks(long availableBooks) {
		this.availableBooks = availableBooks;
	}
	
	

}
